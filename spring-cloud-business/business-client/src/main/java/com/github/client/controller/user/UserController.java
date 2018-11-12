package com.github.client.controller.user;

import com.github.model.po.UserInfo;
import com.github.service.UserInfoServiceImpl;
import java.io.File;
import java.io.IOException;
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
 * @date 2018/9/14
 * @since JDK1.8
 */

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserInfoServiceImpl userService;

  @PostMapping
  public UserInfo createUser(@RequestBody UserInfo user) {
    userService.save(user);
    return user;
  }

  @GetMapping("{id}")
  public UserInfo getId(@PathVariable int id) {
    return userService.getById(id);
  }

  @PutMapping("{id}")
  public UserInfo putUser(@PathVariable int id, @RequestBody UserInfo user) {
    user.setId(id);
    userService.updateById(user);
    return user;
  }

  @DeleteMapping("{id}")
  public UserInfo deleteUser(@PathVariable int id) {
    userService.removeById(id);
    return userService.getById(id);
  }

  @PostMapping("file")
  public String upload(@RequestParam("file") MultipartFile file) {
    try {
      file.transferTo(new File("/Users/dujf/Downloads/diamonds.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return file.getOriginalFilename();
  }
}
