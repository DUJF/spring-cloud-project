package com.github.feign.client;

import com.github.model.po.UserInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/9/18
 * @since JDK1.8
 */
@Component
public class UserClientHystrix implements UserClient {


  @Override public UserInfo postUserInfo(UserInfo userInfo) {
    return null;
  }

  @Override public UserInfo getUserInfo(int id) {
    return getUserInfo();
  }

  @Override public UserInfo putUserInfo(int id, UserInfo userInfo) {
    return getUserInfo();
  }

  @Override public UserInfo deleteUserInfo(int id) {
    return getUserInfo();
  }

  @Override public String upload(MultipartFile file) {
    return "error upload file";
  }

  private UserInfo getUserInfo() {
    UserInfo userInfo = new UserInfo();
    userInfo.setId(100);
    userInfo.setAccount("zhangsan");
    userInfo.setPassword("zhangsan");
    return userInfo;
  }
}
