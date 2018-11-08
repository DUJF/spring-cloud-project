package com.github.client2.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/12
 * @since JDK1.8
 */
@FeignClient("SERVICE-EUREKA-CLIENT") public interface Client1Client {

  @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
  String getHello();

}
