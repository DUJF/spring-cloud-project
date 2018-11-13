package com.github.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.mapper.UserInfoMapper;
import com.github.model.po.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dujf
 * @since 2018-11-08
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

  @Autowired
  private UserInfoMapper userInfoMapper;
}
