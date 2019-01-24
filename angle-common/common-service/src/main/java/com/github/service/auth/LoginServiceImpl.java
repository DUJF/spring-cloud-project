package com.github.service.auth;

import com.github.mapper.UserInfoMapper;
import com.github.model.params.LoginParam;
import com.github.model.po.UserInfo;
import com.github.service.UserInfoService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
//import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
//import org.springframework.web.HttpRequestMethodNotSupportedException;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/11/8
 * @since JDK1.8
 */
@Service
public class LoginServiceImpl implements LoginService {

//  @Autowired
//  private TokenEndpoint tokenEndpoint;

  @Autowired
  private UserInfoMapper userInfoMapper;

//  @Override
//  public ResponseEntity<OAuth2AccessToken> loginIn(LoginParam loginParam) throws HttpRequestMethodNotSupportedException {
//    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("client", "", new ArrayList<>());
//    return tokenEndpoint.postAccessToken(token, getParams(loginParam));
//  }

  @Override public void register(LoginParam loginParam) {
    if (!loginParam.getPassword().isEmpty() && !loginParam.getUsername().isEmpty()) {
      UserInfo userInfo = new UserInfo();
      userInfo.setAccount(loginParam.getUsername());
//      userInfo.setPassword(BCrypt.hashpw(loginParam.getPassword(), BCrypt.gensalt()));
      userInfoMapper.insert(userInfo);
    } else {
      throw new RuntimeException();
    }
  }

  private Map<String, String> getParams(LoginParam param) {
    Map<String, String> map = new HashMap<>();
    map.put("username", param.getUsername());
    map.put("password", param.getPassword());
    map.put("grant_type", "password");
    map.put("scope", "read");
    return map;
  }
}
