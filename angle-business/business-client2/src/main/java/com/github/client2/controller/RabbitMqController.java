package com.github.client2.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.github.client2.component.Publisher;
import com.github.model.po.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping()
  public R getHello(String message) {
    publisher.sendStringMessage(message);
    return R.ok(message);
  }

  @PostMapping("/message")
  public R getHello(@RequestBody Message message) {
    publisher.sendMessage(message);
    return R.ok(message);
  }
}
