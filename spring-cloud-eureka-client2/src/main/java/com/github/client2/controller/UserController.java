package com.github.client2.controller;

import com.github.client2.config.JwtConfig;
import com.github.common.core.RespBody;
import com.github.common.util.EncryptionHelper;
import com.github.common.util.JwtUtils;
import com.github.client2.util.RedisUtils;
import com.github.common.util.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dellll
 */
@RestController
@Api(description = "用户登录", tags = "用户登录")
public class UserController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private JwtConfig jwtConfig;


    /**
     * 登录，根据用户密码 生成token。
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录")
    public RespBody login(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {

        String pwd = "123456";
        String uname = "admin";
        password = EncryptionHelper.encryptPassword(password);
        //根据用户名查数据库
        if (EncryptionHelper.encryptPassword(pwd).equals(password)) {
            String userId = "1001";
            String secret = EncryptionHelper.encryptPassword(userId);
            String accessToken = JwtUtils.getToken(userId, secret, new Long(jwtConfig.getAccessToken()));
            String refreshToken = JwtUtils.getToken(userId, secret, new Long(jwtConfig.getRefreshToken()));

            RedisUtils.set(redisTemplate, accessToken, accessToken, new Long(jwtConfig.getAccessToken()));
            RedisUtils.set(redisTemplate, refreshToken, accessToken, new Long(jwtConfig.getRefreshToken()));

            Map<String, Object> map = new HashMap<>();
            map.put("accessToken", accessToken);
            map.put("refreshToken", refreshToken);
            return ResultUtils.success(map);
        } else {
            return ResultUtils.serverError("error", "password wrong");
        }
    }


}
