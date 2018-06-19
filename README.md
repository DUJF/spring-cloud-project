# spring-cloud-4
 spring cloud项目实践
### 1. 首先建立一个服务注册中心 [服务注册中心](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-eureka)
### 2. 创建多个服务提供者（本实例中的client，client2)
服务资源微服务[clinet](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-config-client)
认证微服务[client2](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-config-client2)
### 3. 创建zuul网关[网关源码](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-zuul)
访问权限认证中心[client2](https://github.com/DUJF/spring-cloud-4/tree/master/spring-cloud-eureka-client2)
获取token http://localhost:8013/api-b/login?username=a&password=123456 (Post) 会经过zuul处理后，访问到client2的login接口
----
使用swagger 生成统一的接口管理文档
再提供服务的微服务中添加
````xml
<!--Swagger 构建的API文档汇集工具-->
        <dependency>
            <groupId>com.spring4all</groupId>
            <artifactId>swagger-spring-boot-starter</artifactId>
            <version>1.7.0.RELEASE</version>
        </dependency>
````
````properties
###需要扫描的包#########
#############swagger api构建工具########
swagger.base-package=com.github
````
添加注解@EnableSwagger2Doc
在zuul添加配置
````java
@Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {
        @Override
        public List<SwaggerResource> get() {
            List resources = new ArrayList<>();
            //location   name :api-a 是文档名称 /api-a是添加的路由配置
            resources.add(swaggerResource("api-a", "/api-a/v2/api-docs", "1.0"));
            resources.add(swaggerResource("api-b", "/api-b/v2/api-docs", "1.0"));
            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }
````

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
### 6. spring cloud ribbon 负载均衡 和 hystrix 容错保护
````java
/**
     * 注册一个具有容错功能的RestTemplate
     * LoadBalanced开启负载均衡客户端
     *
     * @return
     */
    @LoadBalanced
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
````
service层处理
````java
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    RestTemplate restTemplate;

    //注解指定发生错误时的回调方法
    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String getHello() {
        //Get请求调用服务，restTemplate被@LoadBalanced注解标记，Get方法会自动进行负载均衡
        //直接通过注册到服务注册中心的实例id 访问就行
        String result = restTemplate.getForObject("http://service-eureka-client/hello", String.class);
        return result;
    }
    //发生错误时调用 同上面指定的一致
    public String helloFallBack() {
        return "Error occurred ！";
    }
}
````


未完待续，后续添加负载均衡等
