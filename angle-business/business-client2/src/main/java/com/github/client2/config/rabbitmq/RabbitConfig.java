package com.github.client2.config.rabbitmq;

import com.github.client2.constant.QueueConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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
  public Queue helloQueue() {
    return new Queue("hello");
  }

  @Bean
  public Queue userMessage() {
    return new Queue(QueueConstant.USER_MESSAGE);
  }

  @Bean
  public Queue directQueue() {
    return new Queue("direct");
  }

  @Bean
  DirectExchange directExchange() {
    return new DirectExchange("directExchange");
  }

  @Bean
  Binding bindingExchangeDirectQueue(Queue directQueue, DirectExchange directExchange) {
    return BindingBuilder.bind(directQueue).to(directExchange).with("direct");
  }
}
