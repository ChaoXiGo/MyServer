# Swagger

## swagger3.0
1` 3.0依赖集成了UI
```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-boot-starter</artifactId>
    <version>3.0.0</version>
</dependency>
```
2` 创建配置文件
```java
@Configuration
// swagger3.0
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        // DocumentationType.OAS_30 3.0配置
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo());
    }
    
    private ApiInfo apiInfo(){
        /*作者信息*/
        Contact contact = new Contact("朝西", "给个地址", "351306651@qq.com");
        return new ApiInfo(
                "Swagger 测试接口文档",
                "Spring Boot 集成 Swagger 测试接口文档",
                "v1.0",
                "https://www.baidu.com",
                contact,
                "Apache 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}
```

3` 解决空指针的两个方法

yml中添加
```yml
mvc:
pathmatch:
  matching-strategy: ant_path_matcher
```

启动类上添加 @EnableWebMvc