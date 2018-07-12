package com.github.consul;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableDiscoveryClient
@EnableSwagger2Doc
@EnableFeignClients
@SpringBootApplication
public class ConsulApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConsulApplication.class, args);
  }
}
