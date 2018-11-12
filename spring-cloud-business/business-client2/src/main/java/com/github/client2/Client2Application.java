package com.github.client2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * token 认证微服务
 *
 * @author dellll
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.github")
public class Client2Application {

  public static void main(String[] args) {
    SpringApplication.run(Client2Application.class, args);
    String line = "============================================";
    System.out.println(line + "\n http://localhost:8012 \n" + line);
  }
}
