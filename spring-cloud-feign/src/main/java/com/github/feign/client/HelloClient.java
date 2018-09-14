package com.github.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/9/13
 * @since JDK1.8
 */
@FeignClient("SERVICE-EUREKA-CLIENT")
public interface HelloClient {

  @RequestMapping(value = "/hello/name", method = RequestMethod.GET, consumes = { "application/json;charset=UTF-8" })
  String getHello(@RequestParam("name") String name);
}
