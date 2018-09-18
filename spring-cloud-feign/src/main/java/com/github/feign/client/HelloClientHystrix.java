package com.github.feign.client;

import org.springframework.stereotype.Component;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/9/18
 * @since JDK1.8
 */
@Component
public class HelloClientHystrix implements HelloClient {

  @Override public String getHello(String name) {
    return "服务降级返回结果";
  }
}
