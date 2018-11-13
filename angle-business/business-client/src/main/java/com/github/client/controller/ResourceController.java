package com.github.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dellll
 */
@RestController
public class ResourceController {


  @Autowired
  private RedisTemplate redisTemplate;

  @GetMapping("hello/id")
  public String getId() {
    return String.valueOf(redisTemplate.opsForHash().increment("", "", 1L));
  }
}
