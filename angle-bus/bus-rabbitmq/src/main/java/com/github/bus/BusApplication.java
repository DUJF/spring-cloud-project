package com.github.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@RestController
@EnableSwagger2
public class BusApplication {

  public static void main(String[] args) {
    SpringApplication.run(BusApplication.class, args);
  }


  @GetMapping("name")
  public String getHello() {
    return "hello world";
  }
}
