package com.github.ribbon.controller;

import com.github.ribbon.service.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("hello")
public class HelloController {

  @Autowired
  private HelloServiceImpl helloService;

  @Autowired
  private RedisTemplate redisTemplate;

//  @GetMapping
//  public String Hello() {
//    return helloService.getHello();
//  }

  @GetMapping("id")
  public Long getId() {
    return redisTemplate.opsForHash().increment("", "", 1L);
  }
}
