package com.github.client;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dujf
 */
@EnableEurekaClient
@EnableSwagger2Doc
@EnableSwagger2
@MapperScan("com.github")
@SpringBootApplication(scanBasePackages = "com.github")
public class ClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClientApplication.class, args);
    String line = "============================================";
    System.out.println(line + "\n http://localhost:8011 \n" + line);

  }
}
