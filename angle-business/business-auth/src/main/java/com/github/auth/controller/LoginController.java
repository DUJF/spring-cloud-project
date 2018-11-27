package com.github.auth.controller;

import com.github.core.constants.RequestPath;
import com.github.model.params.LoginParam;
import com.github.service.auth.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/11/8
 * @since JDK1.8
 */

@RestController
@RequestMapping()
public class LoginController {

  @Autowired
  private LoginServiceImpl loginService;

  @PostMapping(RequestPath.LOGIN)
  public void loginIn(@RequestBody LoginParam loginParam) {
//    try {
//      ResponseEntity accessToken = loginService.loginIn(loginParam);
//      OAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken.getBody();
//    } catch (HttpRequestMethodNotSupportedException e) {
//      e.printStackTrace();
//    }
  }

  @PostMapping(RequestPath.REGISTER)
  public void register(@RequestBody LoginParam loginParam) {
    try {
      loginService.register(loginParam);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
}
