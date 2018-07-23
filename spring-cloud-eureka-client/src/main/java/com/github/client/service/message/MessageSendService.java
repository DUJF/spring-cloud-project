package com.github.client.service.message;

import com.github.common.core.RabbitMqConstants;
import com.github.common.model.Message;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import springfox.documentation.spring.web.json.Json;

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/12
 * @since JDK1.8
 * <p>
 * 如果需要在生产者需要消息发送后的回调，需要对rabbitTemplate设置ConfirmCallback对象，由于不同的生产者需要对应不同的ConfirmCallback，如果rabbitTemplate设置为单例bean，则所有的rabbitTemplate
 */
@Component
public class MessageSendService implements RabbitTemplate.ConfirmCallback {

  private final AmqpTemplate rabbitTemplate;

  @Autowired public MessageSendService(AmqpTemplate rabbitTemplate) {this.rabbitTemplate = rabbitTemplate;}

  public void send(
      String message
  ) {
    Assert.notNull(message, "message is not null");
    Message message1 = new Message();
    message1.setMessageId(UUID.randomUUID().toString().replaceAll("-", ""));
    String context = "hi, i am " + message + " 1";
    message1.setContent(context);
    try {
      byte[] bytes = getBytesFromObject(message1);
      this.rabbitTemplate.convertAndSend(RabbitMqConstants.EXCHANGE_A, RabbitMqConstants.TOPIC_QUEUE1, bytes);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


  public void send2(
      String message
  ) {
    Assert.notNull(message, "message is null");
    Message m = new Message();
    m.setContent(message);
    m.setMessageId(UUID.randomUUID().toString().replaceAll("-", ""));
    //对象转化为字节码 把对象转化为字节码后，把字节码传输过去再转化为对象
    try {
      byte[] bytes = getBytesFromObject(m);
      this.rabbitTemplate.convertAndSend(RabbitMqConstants.EXCHANGE_A, RabbitMqConstants.TOPIC_QUEUE2, bytes);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override public void confirm(CorrelationData correlationData, boolean b, String s) {
    if (b) {
      System.out.println("消息成功消费");
    } else {
      System.out.println("消息消费失败:" + s);

    }
  }

  //对象转化为字节码
  private byte[] getBytesFromObject(Serializable obj) throws Exception {
    if (obj == null) {
      return null;
    }
    ByteArrayOutputStream bo = new ByteArrayOutputStream();
    ObjectOutputStream oo = new ObjectOutputStream(bo);
    oo.writeObject(obj);
    return bo.toByteArray();
  }
}
