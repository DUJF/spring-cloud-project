# spring-cloud-4
 spring cloud项目实践
### 1. 首先建立一个服务注册中心 [服务注册中心](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-eureka)
### 2. 创建多个服务提供者（本实例中的client，client2)
### 3. 创建zuul网关[网关源码](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-zuul)
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
未完待续，后续添加服务配置中心等
