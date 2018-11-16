angle-config 配置中心

config-server 配置注释
```properties
server.port=8014
spring.application.name=config-server
#公共注册中心
eureka.client.serviceUrl.defaultZone=http://118.24.255.*:8010/eureka/
spring.cloud.config.discovery.enabled=true
spring.cloud.config.discovery.serviceId=config-server
####注册中心 git仓库配置####
# 仓库地址
spring.cloud.config.server.git.uri=https://github.com/athc/angle-cloud.git
# 配置文件所在路径 angle-cloud是根目录 
spring.cloud.config.server.git.search-paths=/angle-config/config-repo
########### 多配置文件信息 ##############
## auth 配置
spring.cloud.config.server.git.repos.auth.uri=https://github.com/athc/angle-cloud.git
spring.cloud.config.server.git.repos.auth.search-paths=/angle-config/config-repo/auth

spring.cloud.config.label=master
spring.cloud.config.profile=dev
#账号密码
spring.cloud.config.server.git.username=king
spring.cloud.config.server.git.password=king
```
访问地址：

配置中心项目结构:

```
angle-cloud 根目录
|
|---angle-config 项目配置中心
|   |
|   |---config-client 
|   |
|   |---config-repo 配置文件位置
|   |   |   
|   |   |---auth
|   |   |   |   
|   |   |   |---auth.properties
|   |   |   |
|   |   |   |---auth-dev.properties
|   |   |   |
|   |   |   |---auth-prod.properties
|   |   |   
|   |   |---config.properties
|   |   |   
|   |   |---config-client.properties
|   |   |   
|   |   |---config-client-dev.properties
|   |   |   
|   |   |---config-client-prod.properties
|   |   |   
|   |   |---config-dev.properties
|   |   |   
|   |   |---config-prod.properties
|   |   
|   |---config-server 配置server
```

访问示例：

http://localhost:8014/config/config 读取config.properties

http://localhost:8014/config/client 读取config.properties 和config-client.properties

http://localhost:8014/config/client-dev 读取config.properties 和 config-client-dev.properties

http://localhost:8014/config/client-prod 读取config.properties 和config-client-prod.properties

http://localhost:8014/config/dev 读取config.properties 和config-dev.properties

http://localhost:8014/config/prod 读取config.properties 和config-prod.properties

多配置读取

http://localhost:8014/auth/auth 读取auth.properties

http://localhost:8014/auth/dev  读取auth.properties 和auth-dev.properties

http://localhost:8014/auth/prod  读取auth.properties 和auth-prod.properties