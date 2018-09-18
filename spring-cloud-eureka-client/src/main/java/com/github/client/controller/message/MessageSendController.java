package com.github.client.controller.message;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/13
 * @since JDK1.8
 */

@RestController
public class MessageSendController {


//  @Autowired
//  private MessageSendService messageSenderService;
//
//
//  @GetMapping("hello1")
//  public void send(
//      @RequestParam String message
//  ) {
//    messageSenderService.send(message);
//  }
//
//  @GetMapping("hello2")
//  public void send2(
//      @RequestParam String message
//  ) {
//    messageSenderService.send2(message);
//  }

  @PostMapping("hello3")
  public String send3(
      @RequestParam(required = false) String message
  ) {
    return "hello world" + message;
  }

}
