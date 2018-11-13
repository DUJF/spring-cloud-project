package com.github.core;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dujf
 */
public class BaseController {
  /**
   * 获取客户端ip
   *
   * @param request
   * @return
   */
  public String getRemoteIP(HttpServletRequest request) {
    String ip = request.getHeader("x-forwarded-for");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }

    // squid的squid.conf 的配制文件中forwarded_for项改为off时
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }

    // 多级反向代理
    if (ip != null && ip.indexOf(",") > 0 && ip.split(",").length > 1) {
      ip = ip.split(",")[0];
    }
    return ip;
  }


  /**
   * 根据名字获取cookie
   *
   * @param request
   * @param name    cookie名字
   * @return
   */
  public static Cookie getCookieByName(HttpServletRequest request, String name) {
    Map<String, Cookie> cookieMap = readCookieMap(request);
    if (cookieMap.containsKey(name)) {
      Cookie cookie = (Cookie) cookieMap.get(name);
      return cookie;
    } else {
      return null;
    }
  }

  /**
   * 将cookie封装到Map里面
   *
   * @param request
   * @return
   */
  private static Map<String, Cookie> readCookieMap(HttpServletRequest request) {
    Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
    Cookie[] cookies = request.getCookies();
    if (null != cookies) {
      for (Cookie cookie : cookies) {
        cookieMap.put(cookie.getName(), cookie);
      }
    }
    return cookieMap;
  }
}
