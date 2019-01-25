package com.github.client2.component;

import com.alibaba.fastjson.JSON;
import com.github.client2.constant.RabbitMqConstant;
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

  /**
   * 发送消息到对列
   *
   * @param message
   */
  public void sendQueueMessage(String message) {
    rabbitTemplate.convertAndSend(RabbitMqConstant.QUEUE_USER_MESSAGE, JSON.toJSONString(message));
  }

  /**
   * 发送消息到交换记
   *
   * @param message
   */
  public void sendStringMessage(String message) {
    rabbitTemplate.convertAndSend(RabbitMqConstant.EXCHANGE_TOPIC, RabbitMqConstant.ROUTING_USER_MESSAGE, JSON.toJSONString(message));
  }

  public void sendStringMessages(String message) {
    rabbitTemplate.convertAndSend(RabbitMqConstant.EXCHANGE_TOPIC, RabbitMqConstant.ROUTING_USER_MESSAGES, JSON.toJSONString(message));
  }

  public void sendDirectMessage(Message message) {
    rabbitTemplate.convertAndSend(RabbitMqConstant.EXCHANGE_TOPIC, RabbitMqConstant.ROUTING_DIRECT_MESSAGE, JSON.toJSONString(message));
  }

  public void sendDirectMessages(Message message) {
    rabbitTemplate.convertAndSend(RabbitMqConstant.EXCHANGE_DIRECT, RabbitMqConstant.ROUTING_DIRECT_MESSAGES, JSON.toJSONString(message));
  }
}
