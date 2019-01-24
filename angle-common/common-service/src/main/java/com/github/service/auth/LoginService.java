package com.github.service.auth;

import com.github.model.params.LoginParam;

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
//  ResponseEntity<OAuth2AccessToken> loginIn(LoginParam loginParam) throws HttpRequestMethodNotSupportedException;

  /**
   * @param loginParam
   * @return
   * @throws HttpRequestMethodNotSupportedException
   */
  void register(LoginParam loginParam);
}
