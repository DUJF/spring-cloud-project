package com.github.client.controller;

import com.github.client.util.ServiceInfoUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dellll
 */
@RestController
public class ResourceController {

  @GetMapping("/hello")
  public String hello() {
    System.out.println("hello world:" + ServiceInfoUtil.getPort());
    return "hello world1:" + ServiceInfoUtil.getPort();
  }
}
