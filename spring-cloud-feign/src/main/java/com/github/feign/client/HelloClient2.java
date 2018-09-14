package com.github.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/9/14
 * @since JDK1.8
 */

@FeignClient("SERVICE-EUREKA-CLIENT2")
public interface HelloClient2 {

  @RequestMapping(value = "/hello", method = RequestMethod.POST, consumes = { "application/json;charset=UTF-8" })
  String getHello();
}
