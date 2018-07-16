package com.github.client.config.rabbitmq;

import com.github.common.core.RabbitMqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/12
 * @since JDK1.8
 */

@Configuration
public class RabbitConfig {

  //创建交换机
  @Bean
  TopicExchange exchange() {
    return new TopicExchange(RabbitMqConstants.EXCHANGE_A);
  }

  //创建topic队列
  @Bean
  public Queue queueMessage() {
    return new Queue(RabbitMqConstants.TOPIC_QUEUE1);
  }

  //创建topic队列
  @Bean
  public Queue queueMessages() {
    return new Queue(RabbitMqConstants.TOPIC_QUEUE2);
  }

  //将交换机与队列绑定
  @Bean
  Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
    return BindingBuilder.bind(queueMessage).to(exchange).with(RabbitMqConstants.ROUNTING_KEY_A);
  }


  //将交换机与队列绑定
  @Bean
  Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
    return BindingBuilder.bind(queueMessages).to(exchange).with(RabbitMqConstants.ROUNTING_KEY_B);
  }

  @Bean
  public RabbitMessagingTemplate rabbitMessagingTemplate(RabbitTemplate rabbitTemplate) {
    RabbitMessagingTemplate rabbitMessagingTemplate = new RabbitMessagingTemplate();
    rabbitMessagingTemplate.setMessageConverter(jackson2Converter());
    rabbitMessagingTemplate.setRabbitTemplate(rabbitTemplate);
    return rabbitMessagingTemplate;
  }

  @Bean
  public MappingJackson2MessageConverter jackson2Converter() {
    return new MappingJackson2MessageConverter();
  }
}