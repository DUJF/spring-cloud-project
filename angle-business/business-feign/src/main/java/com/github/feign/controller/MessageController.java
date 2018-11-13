package com.github.feign.controller;

import com.github.feign.client.MessageSendClient;
import com.github.feign.client.UserClient;
import com.github.model.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/9/13
 * @since JDK1.8
 */
@RestController
@RequestMapping("/feign/message")
public class MessageController {

  @Autowired
  private MessageSendClient messageSendClient;

  @Autowired
  private UserClient userClient;

  @GetMapping
  public String showMessage() {
    return messageSendClient.send3("message");
  }


  @PostMapping
  public UserInfo createUser(@RequestBody UserInfo user) {
    return userClient.postUserInfo(user);
  }

  @GetMapping("{id}")
  public UserInfo getId(@PathVariable int id) {
    return userClient.getUserInfo(id);
  }

  @PutMapping("{id}")
  public UserInfo putUser(@PathVariable int id, @RequestBody UserInfo user) {
    return userClient.putUserInfo(id, user);
  }

  @DeleteMapping("{id}")
  public UserInfo deleteUser(@PathVariable int id) {
    return userClient.deleteUserInfo(id);
  }

  @PostMapping("file")
  public String upload(@RequestParam("file") MultipartFile file) {
    return userClient.upload(file);
  }

}
