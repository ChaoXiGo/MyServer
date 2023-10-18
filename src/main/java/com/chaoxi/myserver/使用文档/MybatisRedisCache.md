# Mybatis二级缓存整合Redis

> 导入redis依赖

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
    <version>3.1.3</version>
</dependency>
```

> 配置redis并开启mybatis二级缓存

```yaml
# 配置数据源
spring:
  # redis 配置
  redis:
    host: 121.196.223.37
    port: 6379
    lettuce:
      pool:
        #最大允许连接数
        max-active: 100
        #最小空闲连接数,最少准备5个可用连接在连接池候着
        min-idle: 5
        #最大空闲连接数,空闲连接超过10个后自动释放
        max-idle: 10
        #当连接池到达上限后,最多等待30秒尝试获取连接,超时报错
        max-wait: 30000
    timeout: 2000
# mybatis配置
mybatis-plus:
  configuration:
    # 开启缓存
    cache-enabled: true
```

> 配置序列化规则
> 
> 存储redis时所需的格式

```java

@Configuration
public class RedisConfig {

    @Bean
    public static RedisTemplate<String, Object> myRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // 序列化配置
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        // String 类型序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        // key及hash采用String类型的序列化
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        // value及hash value序列化采用json序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        template.afterPropertiesSet();
        return template;
    }
}
```

> 手动获取序列化规则模版类 ApplicationContextHolder

```java
@Service
@Lazy(false)
public class ApplicationContextHolder implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return applicationContext;
    }

    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        assertContextInjected();
        return applicationContext.getBean(requiredType);
    }

    public static void clearHolder() {
        applicationContext = null;
    }

    @Override
    public void destroy() throws Exception {
        ApplicationContextHolder.clearHolder();
    }

    private static void assertContextInjected() {
        Assert.state(applicationContext != null,"applicaitonContext属性未注入");
    }
}

```

> 实现Cache接口，因为这个类不是Spring管理的，所以通过SpringContextHolder从ioc容器里获取redisTemplate类

```java

@Slf4j
public class MyBatisRedisCache implements Cache {

    private static RedisTemplate<String , Object> redisTemplate;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    private String id;


    public MyBatisRedisCache(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("cache instances require an id.");
        }
        this.id = id;
        if (redisTemplate == null) {
            redisTemplate = ApplicationContextHolder.getBean("myRedisTemplate");
        }
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void putObject(Object key, Object value) {
        if (!StringUtils.isEmpty(value)) {
            redisTemplate.opsForHash().put(id, key.toString() , value);
            log.info("mybatis缓存,{}:[{}]" , key , value );
        }
    }

    @Override
    public Object getObject(Object key) {
        if (!StringUtils.isEmpty(key)) {
            Object object = redisTemplate.opsForHash().get(id , key.toString());
            log.info("mybatis缓存读取,{}:[{}]", key , object);
            return object;
        }
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        if (!StringUtils.isEmpty(key)) {
            redisTemplate.delete(key.toString());
        }
        return null;
    }

    @Override
    public void clear() {
        redisTemplate.delete(id.toString());
    }

    @Override
    public int getSize() {
        return redisTemplate.opsForHash().size(id.toString()).intValue();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}

```

> 在mapper上增加注解作用域
```java
@Mapper
@CacheNamespace(implementation = MyBatisRedisCache.class ,eviction = MyBatisRedisCache.class)
public interface UserMapper extends BaseMapper<UserEntity> { }
```

> 编写controller查询数据库进行测试

