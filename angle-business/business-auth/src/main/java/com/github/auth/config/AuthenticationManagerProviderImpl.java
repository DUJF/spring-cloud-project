package com.github.auth.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.mapper.UserInfoMapper;
import com.github.model.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/11/9
 * @since JDK1.8
 */
public class AuthenticationManagerProviderImpl implements AuthenticationProvider {
  @Autowired
  private UserInfoMapper userInfoMapper;


  @Override public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    //UserInfo userInfo = userInfoMapper.selectOne(new QueryWrapper<UserInfo>().eq("account", authentication.getName()));
    //return UsernamePasswordAuthenticationToken(user, user.pwd, user.authorities);
    return authentication;
  }

  @Override public boolean supports(Class<?> aClass) {
    return false;
  }
}
