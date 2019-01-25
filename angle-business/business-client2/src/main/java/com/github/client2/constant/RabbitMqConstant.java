package com.github.client2.constant;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-01-24
 * @since JDK1.8
 */
public interface RabbitMqConstant {

  /**
   * queue
   */
  String QUEUE_USER_MESSAGE = "user.message";
  String QUEUE_USER_MESSAGES = "user.messages";
  String QUEUE_DIRECT_MESSAGE = "direct.message";
  String QUEUE_DIRECT_MESSAGES = "direct.messages";

  /**
   * exchange
   */
  String EXCHANGE_TOPIC = "topic.exchange";
  String EXCHANGE_DIRECT = "direct.exchange";

  /**
   * routing
   */
  String ROUTING_USER_MESSAGE = "topic.message";
  String ROUTING_USER_MESSAGES= "topic.#";
  String ROUTING_DIRECT_MESSAGE = "direct.message";
  String ROUTING_DIRECT_MESSAGES= "direct.messages";
}
