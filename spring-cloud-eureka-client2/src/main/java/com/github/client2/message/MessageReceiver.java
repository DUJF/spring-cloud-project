package com.github.client2.message;

import com.github.common.core.RabbitMqConstants;
import com.github.common.model.Message;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
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
  @RabbitListener(queues = RabbitMqConstants.TOPIC_QUEUE1)
  public void process(byte[] bytes) {
    try {
      Message message = (Message) getObjectFromBytes(bytes);
      System.out.println("Receiver  : " + message.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @RabbitHandler
  @RabbitListener(queues = RabbitMqConstants.TOPIC_QUEUE2)
  public void process1(byte[] bytes) {
    try {
      Message message = (Message) getObjectFromBytes(bytes);
      System.out.println("Receiver  : " + message.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //字节码转化为对象
  private Object getObjectFromBytes(byte[] objBytes) throws Exception {
    if (objBytes == null || objBytes.length == 0) {
      return null;
    }
    ByteArrayInputStream bi = new ByteArrayInputStream(objBytes);
    ObjectInputStream oi = new ObjectInputStream(bi);
    return oi.readObject();
  }
}
