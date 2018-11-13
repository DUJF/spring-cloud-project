package com.github.consul;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dujf
 */
@EnableDiscoveryClient
@EnableSwagger2Doc
@SpringBootApplication
public class ConsulApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConsulApplication.class, args);
  }
}
