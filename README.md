# spring-cloud-4
 spring cloud项目实践
### 1. 首先建立一个服务注册中心 [服务注册中心](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-eureka)
### 2. 创建多个服务提供者（本实例中的client，client2)
服务资源微服务[clinet](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-config-client)
认证微服务[client2](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-config-client2)
### 3. 创建zuul网关[网关源码](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-zuul)
访问权限认证中心[client2](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-eureka-client2)
获取token http://localhost:8013/api-b/login?username=a&password=123456 (Post) 会经过zuul处理后，访问到client2的login接口
### 4. 服务配置中心
. [配置服务端](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-config)
服务端搭建好后可以访问http://localhost:8014/config/client 获取到config-client.properties中的信息
**{"name":"config","profiles":["client"],"label":null,"version":null,"state":null,"propertySources":[{"name":"https://github.com/DUJF/spring-cloud-config.git/config-client.properties","source":{"name":"zhangsan","password":"123456"}}]}**

. 配置客户端[2](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-config-client)
客户端搭建好后可以访问http://localhost:8015/name 获取到服务端中的配置信息
````java
@Value("${name}")
    private String name;

    @GetMapping("/name")
    public String getName() {
        return name;
    }
```` 
. 配置文件放在git仓库里[配置文件](https://github.com/DUJF/spring-cloud-config)
----
### 5. spring boot admin 项目监控中心
1. 添加监控中心需要注册在同一个服务注册中心或者在需要监控的微服务配置文件中添加
````properties
# 如果被监控的服务没有注册到服务中心，需要增加admin的地址
 spring.boot.admin.url=http://localhost:8016
# 关闭安全访问,admin 能直接获取相关信息，否则不能直接获取
management.security.enabled=false
````
关闭安全访问，可以直接获取到微服务相关数据



未完待续，后续添加负载均衡等
