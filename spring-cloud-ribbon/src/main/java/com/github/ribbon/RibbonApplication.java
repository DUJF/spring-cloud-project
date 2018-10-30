package com.github.ribbon;

import com.github.ribbon.config.ServiceInfoUtil;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
//开启断路器功能，进行容错管理
@EnableCircuitBreaker
@SpringBootApplication(scanBasePackages = "com.github")
@EnableSwagger2Doc
public class RibbonApplication {

  public static void main(String[] args) {
    SpringApplication.run(RibbonApplication.class, args);
    String line = "============================================";
    System.out.println(line + "\n http://localhost:" + ServiceInfoUtil.getPort() + "\n" + line);

  }

  /**
   * 注册一个具有容错功能的RestTemplate
   * LoadBalanced开启负载均衡客户端
   *
   * @return
   */
  @LoadBalanced
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
