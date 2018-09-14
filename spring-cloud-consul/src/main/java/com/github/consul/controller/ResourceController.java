package com.github.consul.controller;

import com.github.consul.util.ServiceInfoUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dellll
 */
@RestController
public class ResourceController {

  @GetMapping("/hello")
  public String hello() {
    System.out.print("hello world:" + ServiceInfoUtil.getPort());
    return "hello world:" + ServiceInfoUtil.getPort();
  }
}
