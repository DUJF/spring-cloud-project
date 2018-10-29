package com.github.client;

import com.didispace.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableSwagger2Doc
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.github")
public class ClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClientApplication.class, args);
    String line = "============================================";
    System.out.println(line + "\n http://localhost:8011 \n" + line);

  }
}
