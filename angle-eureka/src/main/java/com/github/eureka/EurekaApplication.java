package com.github.eureka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

  @Value("${server.port}")
  private static String port;


  public static void main(String[] args) {
    SpringApplication.run(EurekaApplication.class, args);
    String line = "============================================";
    System.out.println(new StringBuffer(line).append("\n").append("http://localhost:").append(port).append("\n").append(line));

  }
}
