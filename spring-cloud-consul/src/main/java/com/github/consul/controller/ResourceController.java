package com.github.consul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dellll
 */
@RestController
public class ResourceController {

  @GetMapping("/hello")
  public String hello() {
    return "";
  }
}
