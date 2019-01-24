package com.github.client2.component;

import com.alibaba.fastjson.JSON;
import com.github.client2.constant.QueueConstant;
import com.github.model.po.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-01-24
 * @since JDK1.8
 */
@Component
public class Publisher {

  private AmqpTemplate rabbitTemplate;

  @Autowired
  public void getRabbitTemplate(AmqpTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendStringMessage(String message) {
    rabbitTemplate.convertAndSend(QueueConstant.USER_MESSAGE, JSON.toJSONString(message));
  }

  public void sendMessage(Message message) {
    rabbitTemplate.convertAndSend(QueueConstant.USER_MESSAGE, JSON.toJSONString(message));
  }
}
