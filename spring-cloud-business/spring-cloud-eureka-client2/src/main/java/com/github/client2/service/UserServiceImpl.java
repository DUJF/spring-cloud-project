package com.github.client2.service;

import com.github.client2.client.Client1Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="http://github.com/DUJF">dujf</a>
 * @date 2018/7/12
 * @since JDK1.8
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private Client1Client client1Client;

  @Override public String getHello() {
    return client1Client.getHello();
  }
}
