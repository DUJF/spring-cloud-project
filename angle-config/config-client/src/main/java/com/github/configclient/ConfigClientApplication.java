package com.github.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dujf
 */
@SpringBootApplication
@RestController
@RefreshScope
@EnableSwagger2
public class ConfigClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConfigClientApplication.class, args);
    String line = "============================================";
    System.out.println(new StringBuffer(line).append("\n http://localhost:8015 \n").append(line));
  }

  @Value("${name}")
  private String name;

  @GetMapping("/name")
  public String getName() {
    return name;
  }
}
