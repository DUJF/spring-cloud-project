package com.github.client.message;

import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/12
 * @since JDK1.8
 */
@RestController
public class MessageSender {

  @Autowired
  private AmqpTemplate rabbitTemplate;

  @GetMapping("/message1")
  public void send(
      @RequestParam String message
  ) {
    String context = "hi, i am " + message + " 1";
    System.out.println("Sender : " + context);
    this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
  }

  @GetMapping("/message2")
  public void send2(
      @RequestParam String message
  ) {
    String context = "hi, i am " + message + " 2";
    System.out.println("Sender : " + context);
    this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
  }

}
