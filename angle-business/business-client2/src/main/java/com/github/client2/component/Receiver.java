package com.github.client2.component;

import com.github.client2.constant.RabbitMqConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-01-24
 * @since JDK1.8
 */
@Component
public class Receiver {

  @RabbitHandler
  @RabbitListener(queues = RabbitMqConstant.QUEUE_USER_MESSAGE)
  public void processMessage(String message) {
    System.out.println("接收者 QUEUE_USER_MESSAGE : " + message);
  }

  @RabbitHandler
  @RabbitListener(queues = RabbitMqConstant.QUEUE_USER_MESSAGES)
  public void processUserRole(String message) {
    System.out.println("接收者 QUEUE_USER_MESSAGES : " + message);
  }

  @RabbitHandler
  @RabbitListener(queues = RabbitMqConstant.QUEUE_DIRECT_MESSAGE)
  public void processPermission(String message) {
    System.out.println("接收者 QUEUE_DIRECT_MESSAGE : " + message);
  }

  @RabbitHandler
  @RabbitListener(queues = RabbitMqConstant.QUEUE_DIRECT_MESSAGES)
  public void processDirectPermission(String message) {
    System.out.println("接收者 QUEUE_DIRECT_MESSAGES : " + message);
  }
}
