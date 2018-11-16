package com.github.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author dujf
 * 访问配置信息：
 * <p>
 * / {application} / {profile} [ / {label} ]
 * / {application} - {profile} . yml
 * / {label} / {application} - {profile} . yml
 * / {application} - {profile} . properties
 * / {label} / {application} - {profile} . properties
 */
@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class ConfigApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConfigApplication.class, args);
    String line = "============================================";
    System.out.println(new StringBuffer(line).append("\n http://localhost:8014 \n").append(line));
  }
}
