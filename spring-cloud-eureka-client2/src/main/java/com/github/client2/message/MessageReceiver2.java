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
public class MessageReceiver2 {

  /**
   * 出现No method found for class [B
   *
   * 将@RabbitListener(queues = "topic.messages") 注解放在方法上
   * @param hello
   */

  @RabbitHandler
  @RabbitListener(queues = "topic.messages")
  public void process(String hello) {
    System.out.println("Receiver  : " + hello);
  }
}