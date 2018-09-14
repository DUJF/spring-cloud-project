package com.github.client.controller;

import com.github.client.util.ServiceInfoUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dellll
 */
@RestController
public class ResourceController {

  //测试重命名仓库
  @GetMapping("/hello")
  public String hello() {
    System.out.println("hello world:" + ServiceInfoUtil.getPort());
    return "hello world1:" + ServiceInfoUtil.getPort();
  }

  //测试重命名仓库
  @GetMapping("/hello/name")
  public String hello1(String name) {
    System.out.println("hello world:" + name + ServiceInfoUtil.getPort());
    return "hello world1:" + name + ServiceInfoUtil.getPort();
  }
}
