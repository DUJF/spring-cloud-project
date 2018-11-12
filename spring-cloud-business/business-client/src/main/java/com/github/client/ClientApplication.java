package com.github.client;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
@SpringBootApplication(scanBasePackages = "com.github")
public class ClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClientApplication.class, args);
    String line = "============================================";
    System.out.println(line + "\n http://localhost:8011 \n" + line);

  }
}
