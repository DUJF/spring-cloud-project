package com.github.feign.client;

import com.github.common.model.User;
import org.springframework.stereotype.Component;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/9/18
 * @since JDK1.8
 */
@Component
public class UserClientHystrix implements UserClient {


  @Override public User postUser(User user) {
    return getUser();
  }

  @Override public User getUser(int id) {
    return getUser();
  }

  @Override public User putUser(int id, User user) {
    return getUser();
  }

  @Override public User deleteUser(int id) {
    return getUser();
  }

  private User getUser() {
    User user = new User();
    user.setId(100);
    user.setUsername("zhangsan");
    user.setPassword("zhangsan");
    return user;
  }
}
