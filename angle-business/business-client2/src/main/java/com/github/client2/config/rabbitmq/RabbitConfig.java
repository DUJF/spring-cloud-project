package com.github.client2.config.rabbitmq;

import com.github.client2.constant.RabbitMqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/13
 * @since JDK1.8
 */
@Configuration
public class RabbitConfig {

  @Bean
  public Queue userMessage() {
    return new Queue(RabbitMqConstant.QUEUE_USER_MESSAGE);
  }

  @Bean
  public Queue userMessages() {
    return new Queue(RabbitMqConstant.QUEUE_USER_MESSAGES);
  }

  @Bean
  public Queue directQueue() {
    return new Queue(RabbitMqConstant.QUEUE_DIRECT_MESSAGE);
  }

  @Bean
  public Queue directQueues() {
    return new Queue(RabbitMqConstant.QUEUE_DIRECT_MESSAGES);
  }

  @Bean
  DirectExchange directExchange() {
    return new DirectExchange(RabbitMqConstant.EXCHANGE_DIRECT);
  }

  /**
   * 交换机(Exchange) 描述：接收消息并且转发到绑定的队列，交换机不存储消息
   */
  @Bean
  TopicExchange topicExchange() {
    return new TopicExchange(RabbitMqConstant.EXCHANGE_TOPIC);
  }

  @Bean
  Binding bindingExchangeDirectQueue(Queue directQueue, DirectExchange directExchange) {
    return BindingBuilder.bind(directQueue).to(directExchange).with(RabbitMqConstant.ROUTING_DIRECT_MESSAGE);
  }

  @Bean
  Binding bindingExchangeDirectQueue2(Queue directQueues, DirectExchange directExchange) {
    return BindingBuilder.bind(directQueues).to(directExchange).with(RabbitMqConstant.ROUTING_DIRECT_MESSAGES);
  }

  @Bean
  Binding bindingTopicExchangeQueue2(Queue userMessage, TopicExchange topicExchange) {
    return BindingBuilder.bind(userMessage).to(topicExchange).with(RabbitMqConstant.ROUTING_USER_MESSAGE);
  }

  @Bean
  Binding bindingTopicExchangeQueue(Queue userMessages, TopicExchange topicExchange) {
    return BindingBuilder.bind(userMessages).to(topicExchange).with(RabbitMqConstant.ROUTING_USER_MESSAGES);
  }
}
