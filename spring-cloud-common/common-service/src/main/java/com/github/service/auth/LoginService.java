package com.github.service.auth;

import com.github.model.params.LoginParam;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.HttpRequestMethodNotSupportedException;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/11/8
 * @since JDK1.8
 */
public interface LoginService {

  /**
   * @param loginParam
   * @return
   * @throws HttpRequestMethodNotSupportedException
   */
  ResponseEntity<OAuth2AccessToken> loginIn(LoginParam loginParam) throws HttpRequestMethodNotSupportedException;

  /**
   * @param loginParam
   * @return
   * @throws HttpRequestMethodNotSupportedException
   */
  void register(LoginParam loginParam);
}
