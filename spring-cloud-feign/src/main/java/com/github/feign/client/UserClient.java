package com.github.feign.client;

import com.github.common.model.User;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author <a href="http://github.com/athc">dujf</a>
 * @date 2018/9/13
 * @since JDK1.8
 */
@FeignClient(value = "SERVICE-EUREKA-CLIENT", configuration = UserClient.MultipartSupportConfig.class, fallback = UserClientHystrix.class)
public interface UserClient {

  @PostMapping(value = "/user", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
  User postUser(@RequestBody User user);

  @GetMapping(value = "/user/{id}", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
  User getUser(@PathVariable("id") int id);

  @PutMapping(value = "/user/{id}", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
  User putUser(@PathVariable("id") int id, @RequestBody User user);

  @DeleteMapping(value = "/user/{id}", consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE })
  User deleteUser(@PathVariable("id") int id);

  @PostMapping(value = "/user/file", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
  String upload(@RequestPart("file") MultipartFile file);

//  @Configuration
  class MultipartSupportConfig {

    @Bean
    public Encoder feignFormEncoder() {
      return new SpringFormEncoder();
    }

    @Bean
    public feign.Logger.Level multipartLoggerLevel() {
      return feign.Logger.Level.HEADERS;
    }
  }
}
