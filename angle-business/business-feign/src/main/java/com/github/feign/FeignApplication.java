package com.github.feign;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author dujf
 */
@SpringBootApplication(scanBasePackages = "com.github")
@MapperScan(basePackages = "com.github")
@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
@EnableHystrixDashboard
@EnableEurekaClient
@EnableCircuitBreaker
public class FeignApplication {

  public static void main(String[] args) {
    SpringApplication.run(FeignApplication.class, args);
  }
}
