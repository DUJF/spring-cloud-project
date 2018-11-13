package com.github.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lijunhong on 17/11/6.
 * md5 加密工具包
 */
public final class MD5Utils {

  /**
   * 获取MD5加密后的字符串
   *
   * @param str 明文
   * @return 加密后的字符串
   */
  public static String getMD5(String str) {
    //创建MD5加密对象
    MessageDigest md5;
    byte[] md5Bytes;
    StringBuilder res;
    int temp;

    try {
      md5 = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("MD5加密对象初始化失败。", e);
    }
    //进行加密
    md5.update(str.getBytes());
    //获取加密后的字节数组
    md5Bytes = md5.digest();
    res = new StringBuilder(32);
    for (byte md5Byte : md5Bytes) {
      temp = md5Byte & 0xFF;
      if (temp <= 0XF) { // 转化成十六进制不够两位，前面加零
        res.append("0");
      }
      res.append(Integer.toHexString(temp));
    }
    return res.toString();
  }
}
