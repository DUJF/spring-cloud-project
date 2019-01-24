package com.github.client2.component;

import com.github.client2.constant.QueueConstant;
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
  @RabbitListener(queues = QueueConstant.USER_MESSAGE)
  public void processHello(String message) {
    System.out.println("接收者 helloReceiver," + message);
  }

}
