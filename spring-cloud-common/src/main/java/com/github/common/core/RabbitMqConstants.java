package com.github.common.core;

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/13
 * @since JDK1.8
 */
public class RabbitMqConstants {

  //交换机
  public static final String EXCHANGE_A = "exchange-a";
  public static final String EXCHANGE_B = "exchange-b";
  public static final String EXCHANGE_C = "exchange-c";

  //消息队列
  public static final String TOPIC_QUEUE1 = "topic.message1";
  public static final String TOPIC_QUEUE2 = "topic.message2";
  public static final String TOPIC_QUEUE3 = "topic.message3";
  public static final String TOPIC_QUEUE4 = "topic.message4";
  public static final String TOPIC_QUEUE5 = "topic.message5";
  public static final String TOPIC_QUEUE6 = "topic.message6";

  //路由规则
  public static final String ROUNTING_KEY_A = "topic.message1";
  public static final String ROUNTING_KEY_B = "topic.#";
  public static final String ROUNTING_KEY_C = "topic.*";
  public static final String ROUNTING_KEY_D = "topic.message4";
  public static final String ROUNTING_KEY_E = "topic.message5";
  public static final String ROUNTING_KEY_F = "topic.message6";

}
