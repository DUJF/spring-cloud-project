package com.github.client.controller.user;

import com.github.client.service.user.UserService;
import com.github.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/9/14
 * @since JDK1.8
 */

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @GetMapping("{id}")
  public User getId(@PathVariable int id) {
    User user = new User();
    user.setId(id);
    return userService.createUser(user);
  }

  @PutMapping("{id}")
  public User putUser(@PathVariable int id, @RequestBody User user) {
    user.setId(id);
    return userService.createUser(user);
  }

  @DeleteMapping("{id}")
  public User deleteUser(@PathVariable int id) {
    User user = new User();
    user.setId(id);
    return userService.createUser(user);
  }
}
