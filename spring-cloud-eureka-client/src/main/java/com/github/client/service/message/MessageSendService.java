package com.github.client.service.message;

import com.github.common.core.RabbitMqConstants;
import com.github.common.model.Message;
import java.util.HashMap;
import java.util.Map;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/12
 * @since JDK1.8
 * <p>
 * 如果需要在生产者需要消息发送后的回调，需要对rabbitTemplate设置ConfirmCallback对象，由于不同的生产者需要对应不同的ConfirmCallback，如果rabbitTemplate设置为单例bean，则所有的rabbitTemplate
 */
@Component
public class MessageSendService {

  private final AmqpTemplate rabbitTemplate;

  @Autowired public MessageSendService(AmqpTemplate rabbitTemplate) {this.rabbitTemplate = rabbitTemplate;}

  public void send(
      String message
  ) {
    Assert.notNull(message, "message is not null");
    Map<String, Object> map = new HashMap<>();
    map.put(message, message);
    Assert.notNull(message, "message is null");
    String message1 = Message.productMessage(1, 2, 1, map, 1);
    try {
      this.rabbitTemplate.convertAndSend(RabbitMqConstants.EXCHANGE_A, RabbitMqConstants.TOPIC_QUEUE1, message1);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void send2(
      String message
  ) {
    Map<String, Object> map = new HashMap<>();
    map.put(message, message);
    Assert.notNull(message, "message is null");
    String message1 = Message.productMessage(1, 2, 1, map, 1);
    //对象转化为字节码 把对象转化为字节码后，把字节码传输过去再转化为对象
    try {
      this.rabbitTemplate.convertAndSend(RabbitMqConstants.EXCHANGE_A, RabbitMqConstants.TOPIC_QUEUE2, message1);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
