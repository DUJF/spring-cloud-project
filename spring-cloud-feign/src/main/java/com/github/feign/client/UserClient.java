package com.github.feign.client;

import com.github.common.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/9/13
 * @since JDK1.8
 */
@FeignClient("SERVICE-EUREKA-CLIENT")//, fallback = UserClientHystrix.class)
public interface UserClient {

  @PostMapping(value = "/user", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
  User postUser(@RequestBody User user);

  @GetMapping(value = "/user/{id}", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
  User getUser(@PathVariable("id") int id);

  @PutMapping(value = "/user/{id}", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
  User putUser(@PathVariable("id") int id, @RequestBody User user);

  @DeleteMapping(value = "/user/{id}", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
  User deleteUser(@PathVariable("id") int id);
}
