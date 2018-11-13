package com.github.client2.controller;

import com.github.client2.config.JwtConfig;
import com.github.client2.util.RedisUtils;
import com.github.core.RespBody;
import com.github.core.utils.EncryptionHelper;
import com.github.core.utils.JwtUtils;
import com.github.core.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dellll
 */
@RestController("/auth")
@Api(tags = "获取token", description = "获取token")
public class TokenController {

  private Logger log = LoggerFactory.getLogger(TokenController.class);

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private JwtConfig jwtConfig;


  /**
   * 根据refreshToken 创建 accessToken,refreshToken
   */
  @GetMapping("/refresh/token")
  @ApiOperation(value = "根据refreshtoken获取token")
  public RespBody refreshToken(ServletRequest request) {
    try {
      log.info("token-service-------refreshToken");
      HttpServletRequest httpServletRequest = (HttpServletRequest) request;
      String refreshToken = httpServletRequest.getHeader("token");
      String accessToken = httpServletRequest.getHeader("accessToken");

      RedisUtils.set(redisTemplate, accessToken, accessToken, new Long(jwtConfig.getExp()));
      RedisUtils.set(redisTemplate, refreshToken, accessToken, new Long(jwtConfig.getExp()));

      String userId = JwtUtils.getUserId(refreshToken);
      String secret = EncryptionHelper.encryptPassword(userId);

      accessToken = JwtUtils.getToken(userId, secret, new Long(jwtConfig.getAccessToken()));
      refreshToken = JwtUtils.getToken(userId, secret, new Long(jwtConfig.getRefreshToken()));

      RedisUtils.set(redisTemplate, accessToken, accessToken, new Long(jwtConfig.getAccessToken()));
      RedisUtils.set(redisTemplate, refreshToken, accessToken, new Long(jwtConfig.getRefreshToken()));
      Map<String, Object> map = new HashMap<>();
      map.put("accessToken", accessToken);
      map.put("refreshToken", refreshToken);
      return ResultUtils.success(map);
    } catch (NumberFormatException e) {
      // TODO Auto-generated catch block
      log.error(e.toString());
      return ResultUtils.serverError("通过refreshtoken获取token失败");
    }
  }

  @RequestMapping(value = "/login/out", method = RequestMethod.GET)
  @ApiOperation(value = "登出")
  public RespBody logout(
      @RequestParam("accessToken") String accessToken,
      @RequestParam("refreshToken") String refreshToken
  ) {
    /**
     * 因为token一旦生成，无法让其过期。当主动刷新，更新token时，将旧的token要做失效处理。
     * 因为存在并发请求，所以不能立即失效，要延后几秒失效。
     */
    RedisUtils.set(redisTemplate, accessToken, accessToken, new Long(jwtConfig.getExp()));
    RedisUtils.set(redisTemplate, refreshToken, refreshToken, new Long(jwtConfig.getExp()));
    return ResultUtils.success();
  }

}
