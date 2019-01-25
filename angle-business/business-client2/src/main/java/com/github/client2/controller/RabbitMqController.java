package com.github.client2.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.github.client2.component.Publisher;
import com.github.model.po.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2019-01-24
 * @since JDK1.8
 */
@RestController
@RequestMapping("mq")
public class RabbitMqController {

  private Publisher publisher;

  @Autowired
  public void getPublisher(Publisher publisher) {
    this.publisher = publisher;
  }


  @PostMapping("q")
  public R sendQueueMessage(String message) {
    publisher.sendQueueMessage(message);
    return R.ok(message);
  }

  @PostMapping("/e/t")
  public R sendStringMessage(String message) {
    publisher.sendStringMessage(message);
    return R.ok(message);
  }

  @PostMapping("/e/ts")
  public R sendStringMessages(String message) {
    publisher.sendStringMessages(message);
    return R.ok(message);
  }

  @PostMapping("/e/d")
  public R sendDirectMessage(@RequestBody Message message) {
    publisher.sendDirectMessage(message);
    return R.ok(message);
  }

  @PostMapping("/e/ds")
  public R sendDirectMessages(@RequestBody Message message) {
    publisher.sendDirectMessages(message);
    return R.ok(message);
  }
}
