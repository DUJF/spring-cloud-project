package com.github.ribbon.controller;

import com.github.ribbon.service.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Autowired
  private HelloServiceImpl helloService;


  @GetMapping
  public String Hello() {
    return helloService.getHello();
  }
}
