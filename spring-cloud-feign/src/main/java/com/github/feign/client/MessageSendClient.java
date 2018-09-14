package com.github.feign.client;

import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/9/13
 * @since JDK1.8
 */
@FeignClient("service-eureka-client")
public interface MessageSendClient {

  @RequestMapping(value = "hello3", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
  String send3(String message);
}
