package com.github.common.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/13
 * @since JDK1.8
 */
public class Message implements Serializable {

  private static final long serialVersionUID = 1L;

  private String messageId;

  private String content;

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
