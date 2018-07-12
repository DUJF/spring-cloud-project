package com.github.client2.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/12
 * @since JDK1.8
 */
@Component
public class MessageReceiver {

  @RabbitHandler
  @RabbitListener(queues = "topic.message")
  public void process(String hello) {
    System.out.println("Receiver  : " + hello);
  }

  @RabbitHandler
  @RabbitListener(queues = "topic.messages")
  public void process1(String hello) {
    System.out.println("Receiver  : " + hello);
  }
}
