package com.github.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author dujf
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZipkinApplication.class, args);
  }
}
