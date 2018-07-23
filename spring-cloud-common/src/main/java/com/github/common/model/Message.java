package com.github.common.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import net.sf.json.JSONObject;

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/13
 * @since JDK1.8
 */
public class Message implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer productCode; // 生产者代码
  private Integer consumerCode; // 消费者代码
  private String messageId; // 消息唯一标识
  private Integer event; // 消息监听事件
  private Integer action; //操作：1加，2减
  private Date created; // 消息发送时间
  private Map<String, Object> bussinessBody; // 消息体，封装业务数据

  private Message() {
    super();
  }

  private Message(Integer productCode, Integer consumerCode, String messageId, Integer event, Date created,
                  Map<String, Object> bussinessBody, Integer action) {
    super();
    this.productCode = productCode;
    this.consumerCode = consumerCode;
    this.messageId = messageId;
    this.event = event;
    this.created = created;
    this.bussinessBody = bussinessBody;
    this.action = action;
  }

  private Message(Integer productCode, Integer consumerCode, Integer event, Map<String, Object> bussinessBody, Integer action) {
    super();
    this.productCode = productCode;
    this.consumerCode = consumerCode;
    this.event = event;
    this.bussinessBody = bussinessBody;
    this.action = action;
  }

  public static String productMessage(Integer productCode, Integer consumerCode, Integer event, Map<String, Object> bussinessBody, Integer action) {
    Message mqObj = new Message(productCode, consumerCode, event, bussinessBody, action);
    mqObj.setCreated(new Date());
    mqObj.setMessageId(generatSeriaeNo());
    return JSONObject.fromObject(mqObj).toString();
  }

  //生成消息唯一标识
  private static String generatSeriaeNo() {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }

  public Integer getProductCode() {
    return productCode;
  }

  public void setProductCode(Integer productCode) {
    this.productCode = productCode;
  }

  public Integer getConsumerCode() {
    return consumerCode;
  }

  public void setConsumerCode(Integer consumerCode) {
    this.consumerCode = consumerCode;
  }

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public Integer getEvent() {
    return event;
  }

  public void setEvent(Integer event) {
    this.event = event;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Map<String, Object> getBussinessBody() {
    return bussinessBody;
  }

  public void setBussinessBody(Map<String, Object> bussinessBody) {
    this.bussinessBody = bussinessBody;
  }

  public Integer getAction() {
    return action;
  }

  public void setAction(Integer action) {
    this.action = action;
  }

  @Override
  public String toString() {
    return "Message [productCode=" + productCode + ", consumerCode="
        + consumerCode + ", messageId=" + messageId + ", event="
        + event + ", action=" + action + ", created=" + created
        + ", bussinessBody=" + bussinessBody + "]";
  }
}
