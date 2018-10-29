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
### 7. 通过feign调用其他client接口
```xml
<!--FeignClient调用Eureka Client接口-->
        <dependency>
           <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-feign</artifactId>
        </dependency>
```
要调用的一端添加接口：
```java
@FeignClient(value = "SERVICE-EUREKA-CLIENT", configuration = UserClient.MultipartSupportConfig.class, fallback = UserClientHystrix.class)
public interface UserClient {

  @PostMapping(value = "/user", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
  User postUser(@RequestBody User user);

  @GetMapping(value = "/user/{id}", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
  User getUser(@PathVariable("id") int id);

  @PutMapping(value = "/user/{id}", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
  User putUser(@PathVariable("id") int id, @RequestBody User user);

  @DeleteMapping(value = "/user/{id}", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
  User deleteUser(@PathVariable("id") int id);

  @PostMapping(value = "/user/file", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
  String upload(@RequestPart("file") MultipartFile file);

  //feign 上传文件编码
  class MultipartSupportConfig {

    @Bean
    public Encoder feignFormEncoder() {
      return new SpringFormEncoder();
    }

    @Bean
    public feign.Logger.Level multipartLoggerLevel() {
      return feign.Logger.Level.HEADERS;
    }
  }
}
```
```java
//注入调用
 	@Autowired
  private UserClient userClinet;

  @PostMapping
    public User createUser(@RequestBody User user) {
      return userClient.postUser(user);
    }
  
    @GetMapping("{id}")
    public User getId(@PathVariable int id) {
      return userClient.getUser(id);
    }
  
    @PutMapping("{id}")
    public User putUser(@PathVariable int id, @RequestBody User user) {
      return userClient.putUser(id,user);
    }
  
    @DeleteMapping("{id}")
    public User deleteUser(@PathVariable int id) {
      return userClient.deleteUser(id);
    }
```
注意：
feign上传文件，需要添加文件编码的相关配置
maven 依赖：
```xml
				<dependency>
            <groupId>io.github.openfeign.form</groupId>
            <artifactId>feign-form</artifactId>
            <version>3.0.3</version>
        </dependency>
        <dependency>
            <groupId>io.github.openfeign.form</groupId>
            <artifactId>feign-form-spring</artifactId>
            <version>3.0.3</version>
        </dependency>
```
编码配置
```java
//  @Configuration 用@Config配置为全局，在@FeignClient(value = "SERVICE-EUREKA-CLIENT", configuration = UserClient.MultipartSupportConfig.class, fallback = UserClientHystrix.class)中配置，仅限本类使用
  class MultipartSupportConfig {

    @Bean
    public Encoder feignFormEncoder() {
      return new SpringFormEncoder();
    }
		//日志等级
    @Bean
    public feign.Logger.Level multipartLoggerLevel() {
      return feign.Logger.Level.HEADERS;
    }
  }
```
>@PostMapping(value = "/user/file", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
   String upload(@RequestPart("file") MultipartFile file);
>目前参数必须使用@RequestPart注解，并且key为"file"
>要配置传送类型为：MULTIPART_FORM_DATA_VALUE
>@Configuration 用@Config配置为全局，在@FeignClient(value = "SERVICE-EUREKA-CLIENT", configuration = UserClient.MultipartSupportConfig.class, fallback = UserClientHystrix.class)中配置，仅限本类使用

kotlin文档：https://www.jianshu.com/p/c8dc5ea7f10f

### 8.jib构建Spring boot项目docker镜像
Jib 是 Google 开发的可以直接构建 Java 应用的 Docker 和 OCI 镜像的类库，以 Maven 和 Gradle 插件形式提供。

通过 Jib，Java 开发者可以使用他们熟悉的 Java 工具来构建容器。Jib 是一个快速而简单的容器镜像构建工具，它负责处理将应用程序打包到容器镜像中所需的所有步骤。它不需要你编写 Dockerfile 或安装 Docker，而且可以直接集成到 Maven 和 Gradle中 —— 只需要将插件添加到构建中，就可以立即将 Java 应用程序容器化。

mvn 添加构建依赖
```xml
<build>
        <plugins>
            <!--mvn build 插件-->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
            <!--jib 构建插件-->
            <plugin>
                <groupId>com.google.cloud.tools</groupId>
                <artifactId>jib-maven-plugin</artifactId>
                <version>0.9.8</version>
                <!--加了这段代码，构建命令 使用mvn package 否则 使用mvn compile jib:dockerBuild -->
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>dockerBuild</goal>
                        </goals>
                    </execution>
                </executions>
                <!--加了这段代码，构建命令 使用mvn package 否则 使用mvn compile jib:dockerBuild -->
                <configuration>
                    <!--
                    from 如果使用aliyun的registry.cn-hangzhou.aliyuncs.com进行加速，需要在mvn配置文件setting.xml添加下面配置
                    <servers>
                        <server>
                          <id>registry.cn-hangzhou.aliyuncs.com</id>
                          <username>你的阿里云账号</username>
                          <password>你的阿里云密码</password>
                        </server>
                    </servers>
                    -->
                    <from>
                        <image>openjdk:8-jre-alpine</image>
                    </from>
                    <!--构建的images 名字 和 tag(自定义)-->
                    <to>
                        <image>athzcc/${project.artifactId}:1.0.0</image>
                    </to>
                </configuration>
            </plugin>
        </plugins>
    </build>
```
使用此插件要先在本机安装docker,构建进入构建项目的根目录，
执行构建命令`mvn compile jib:dockerBuild`,
构建完成在查看`docker images`
![image.png](https://upload-images.jianshu.io/upload_images/11748913-a454b44f26cdee47.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
运行镜像 `docker run  imageName:tag` 
![image.png](https://upload-images.jianshu.io/upload_images/11748913-5c401121fed6f3f5.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
推送到docker hub:
登录docker hub账号
`docker login --username=你的docker hub账号  registry.hub.docker.com`
输入密码登录后将镜像push到docker hub

----
`docker push athzcc/spring-cloud-eureka:1.0.0`
`docker ps -a`查看全部contain(运行和未运行)
`docker rm containId` 移除容器
`docker rmi imagesName`移除镜像
`docker run -it -p8010:8010 athzcc/spring-cloud-eureka:1.0.0` 指定端口号运行镜像


未完待续......
