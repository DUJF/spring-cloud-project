package com.github.client2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * token 认证微服务
 *
 * @author dellll
 */
@EnableDiscoveryClient
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.github")
@EnableSwagger2
@MapperScan("com.github")
public class Client2Application {

  public static void main(String[] args) {
    SpringApplication.run(Client2Application.class, args);
    String line = "============================================";
    System.out.println(line + "\n http://localhost:8012 \n" + line);
  }
}
