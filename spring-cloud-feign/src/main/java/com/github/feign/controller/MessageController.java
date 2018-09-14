package com.github.feign.controller;

import com.github.feign.client.HelloClient;
import com.github.feign.client.MessageSendClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/9/13
 * @since JDK1.8
 */
@RestController
@RequestMapping("/feign/message")
public class MessageController {

  @Autowired
  private MessageSendClient messageSendClient;

  @Autowired
  private HelloClient helloClient;

  @GetMapping
  public String showMessage() {
    return messageSendClient.send3("message");
  }


  @GetMapping("hello")
  public String getHello() {
    return helloClient.getHello("name");
  }

  @GetMapping("/client2/hello")
  public String getHelloClient2() {
    return helloClient.getHello("name");
  }
}
