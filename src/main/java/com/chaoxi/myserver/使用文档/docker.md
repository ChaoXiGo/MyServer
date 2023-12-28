# Docker 命令

```shell
# 查看所有映像
docker images

# 搜索
docker search mysql

# 运行服务
docker run -it 目标id

# 查看进程服务
docker ps

# 查看运行过的服务
docker ps -a

# 停止服务
docker stop 目标id

# 重启服务
docker restart 目标id

# 进入正在后台执行的镜像
docker attach 目标id

# 删除指定容器
docker rm -f 目标id

# 删除全部
docker rm -f $(docker ps -aq)

# 删除指定镜像
docker rmi -f 目标id

# 删除全部镜像
docker rmi -f $(docker images -aq)
```

> ctrl + p + q 快捷键服务后台运行退出到主机

## 数据卷挂载

```shell
# 使用数据卷 -v 命令将主机和容器指定目录进行挂载
docker run -it -v 主机目录:容器内目录
# 具名挂载 (常用)
# 生成在目录 /var/lib/docker/volumes/juming
# 使用mysql需要设置密码 -e MYSQL_ROOT_PASSWORD=123456
docker run -d -p 3306:3306 --name mysql01 -v juming:/etc/mysql/conf.d -e MYSQL_ROOT_PASSWORD=123456 mysql

# 解读: -d 后台运行 -p 映射公网端口3306 -v 挂载主机当前目录下的conf文件和目标容器中的conf.d文件 及 主机下的data文件和目标容器中的mysql文件 -e 设置mysql密码 --name 别名 mysql驱动
docker run -d -p 3306:3306 -v /home/mysql/conf:/etc/mysql/conf.d -v /home/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 --name mysql01 mysql
```

### 多个 Mysql 实现挂载数据共享

```shell
# 运行第一个
docker run -d -p 3306:3306 -v /etc/mysql/conf.d -v /var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 --name mysql-1 mysql
# 通过 --volumes-from 第二个挂载第一个
docker run -d -p 8000:3306 -e MYSQL_ROOT_PASSWORD=123456 --name mysql02 --volumes-from mysql01 mysql

```

## DockerFile

> 构建 docker 镜像的文件 命令参数脚本
>
> 生成文件
>
> `/home/docker-test-volume/dockerfilel`
>
> 编辑 dockerfilel 内容

### 指令

```shell
# 基础镜像
FROM
# 镜像维护者信息 姓名+邮箱
MAINTAINER
# 运行
RUN
# 添加内容 tomcat等
ADD
# 镜像的工作目录
WORKDIR
# 挂载的目录
VOLUME
# 暴露端口配置
EXPOSE
# 指定容器启动的时候运行的命令,最后一个生效,可被替代
CMD
# 同上, 不过可以追加命令
ENTRYPOINT
# 当构建一个被继承的 DockerFile 时触发
ONBUILD
# 类似ADD 将文件拷贝到镜像中
COPY
# 构建的时候设置环境变量
ENV

```

```shell
FROM centos

VOLUME ["volume02","volume02"]

CMD echo "---完成后输出---"

CMD /bin/bash
```

> 使用构建命令生成脚本

```
docker build -f /home/docker-test-volume/dockerfilel -t chaoxi/centos .
```

## Biuld 发布项目

> 将 jar 包和 Dockerfiel 文件放在/home/idea 目录下 并在当前目录下运行生成 chaoxiapp 镜像文件

```shell
# 镜像文件名
docker build -t 自定义镜像名 .
```

### 运行镜像文件

```shell
# -p 小写指定port -P 大写自动生成port
docker run -d -p 8000:8080 --name 别名 镜像
```
