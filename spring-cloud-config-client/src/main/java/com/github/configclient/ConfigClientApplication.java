package com.github.configclient;

import com.github.configclient.config.ServiceInfoUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConfigClientApplication.class, args);
    String line = "============================================";
    System.out.println(line + "\n http://localhost:" + ServiceInfoUtil.getPort() + " \n" + line);
  }

  @Value("${name}")
  private String name;

  @GetMapping("/name")
  public String getName() {
    return name;
  }
}
