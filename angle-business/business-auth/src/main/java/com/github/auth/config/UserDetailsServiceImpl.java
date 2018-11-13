package com.github.auth.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.model.po.UserInfo;
import com.github.service.UserInfoService;
import com.github.service.UserInfoServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/11/8
 * @since JDK1.8
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserInfoServiceImpl userService;

  /**
   * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
   */

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserInfo sysUser = userService.getOne(new QueryWrapper<UserInfo>().eq("account", username));
//    if (null == sysUser) {
//      throw new UsernameNotFoundException(username);
//    }
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//    for (SysRole role : sysUser.getRoleList()) {
//      for (SysPermission permission : role.getPermissionList()) {
//        authorities.add(new SimpleGrantedAuthority(permission.getCode()));
//      }
//    }

    return new User(sysUser.getAccount(), sysUser.getPassword(), authorities);
  }
}
