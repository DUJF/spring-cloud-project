package com.github.core.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * @author dellll
 */
public class EncryptionHelper {
  //加密
  public static String encrypt(String word) {
    String result = "";
    try {
      String KEY_SHA = "SHA";
      MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
      sha.update(word.getBytes());
      byte[] result1 = sha.digest();
      result = (new BASE64Encoder()).encodeBuffer(result1).replaceAll("\\r\\n", "").trim();
    } catch (Exception ex) {
      result = word;
    }

    return result;
  }

  public static String encryptPassword(String word) {
    String pwd = MD5Utils.getMD5(word);
    return pwd;
  }
}
