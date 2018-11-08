//package com.github.client2.message;
//
//import com.github.common.core.RabbitMqConstants;
//import com.github.common.model.Message;
//import net.sf.json.JSONObject;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @author <a href="http://github.com/DUJF">dujf</a>
// * @date 2018/7/12
// * @since JDK1.8
// */
//@Component
//public class MessageReceiver {
//
//  @RabbitHandler
//  @RabbitListener(queues = RabbitMqConstants.TOPIC_QUEUE1)
//  public void process(String m) {
//    try {
//      Message message = stringToMessage(m);
//      System.out.println("Receiver  : " + message.toString());
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  @RabbitHandler
//  @RabbitListener(queues = RabbitMqConstants.TOPIC_QUEUE2)
//  public void process1(String m) {
//    try {
//      Message message = stringToMessage(m);
//      System.out.println("Receiver  : " + message.toString());
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  private Message stringToMessage(String s) {
//    JSONObject jsonObject = JSONObject.fromObject(s);
//    return (Message) JSONObject.toBean(jsonObject, Message.class);
//
//  }
//}
