package com.github.client.service.user;

//import com.github.common.dao.UserDao;

import com.github.common.model.User;
import org.springframework.stereotype.Service;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/9/14
 * @since JDK1.8
 */
@Service
public class UserService {

//  @Autowired
//  private UserDao userDao;


  public User createUser(User user) {
    user.setPassword("aaa");
    user.setUsername("aaa");
    return user;
  }
}
