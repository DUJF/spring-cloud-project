package com.github.common.util;


import com.github.common.core.HttpStatusEnum;
import com.github.common.core.RespBody;

/**
 * @author dellll
 */
public class ResultUtils {

  public static RespBody success(Object object) {
    RespBody RespBody = new RespBody();
    RespBody.setCode(HttpStatusEnum.OK.code());
    RespBody.setMsg(HttpStatusEnum.OK.reasonPhraseUS());
    RespBody.setData(object);
    return RespBody;
  }


  public static RespBody success() {
    RespBody RespBody = new RespBody();
    RespBody.setCode(HttpStatusEnum.OK.code());
    RespBody.setMsg(HttpStatusEnum.OK.reasonPhraseUS());
    return RespBody;
  }


  public static RespBody serverError(String msg, Object object) {
    RespBody RespBody = new RespBody();
    RespBody.setCode(500);
    RespBody.setMsg(msg);
    RespBody.setData(object);
    return RespBody;
  }

  /**
   * 返回未找到资源的错误，如数据记录不存在
   *
   * @param message 错误描述
   */
  public static <E> RespBody<E> notFound(String message) {
    return new RespBody<>(HttpStatusEnum.NOT_FOUND.code(), message, null);
  }

  /**
   * 返回资源冲突的错误，如密码错误
   *
   * @param message 错误描述
   */
  public static <E> RespBody<E> conflict(String message) {
    return new RespBody<>(HttpStatusEnum.CONFLICT.code(), message, null);
  }

  /**
   * 返回资源被锁定的错误，如当前用户被禁用
   *
   * @param message 错误描述
   */
  public static <E> RespBody<E> locked(String message) {
    return new RespBody<>(HttpStatusEnum.LOCKED.code(), message, null);
  }

  /**
   * 返回请求格式的错误，如json不合法
   *
   * @param message 错误描述
   */
  public static <E> RespBody<E> unsupportedMediaType(String message) {
    return new RespBody<>(HttpStatusEnum.UNSUPPORTED_MEDIA_TYPE.code(), message, null);
  }

  /**
   * 返回请求参数的错误，如缺少参数
   *
   * @param message 错误描述
   */
  public static <E> RespBody<E> badRequest(String message) {
    return new RespBody<>(HttpStatusEnum.BAD_REQUEST.code(), message, null);
  }

  /**
   * 返回请求拒绝的错误
   *
   * @param message 错误描述
   */
  public static <E> RespBody<E> forbidden(String message) {
    return new RespBody<>(HttpStatusEnum.FORBIDDEN.code(), message, null);
  }

  /**
   * 返回未认证的错误，如资源没有权限访问
   *
   * @param message 错误描述
   */
  public static <E> RespBody<E> unAuthorized(String message) {
    return new RespBody<>(HttpStatusEnum.UNAUTHORIZED.code(), message, null);
  }

  /**
   * 返回服务器的错误，如捕捉到执行异常
   *
   * @param message 错误描述
   */
  public static <E> RespBody<E> serverError(String message) {
    return new RespBody<>(HttpStatusEnum.INTERNAL_SERVER_ERROR.code(), message, null);
  }

  /**
   * 返回方法未实现的错误
   *
   * @param message 错误描述
   */
  public static <E> RespBody<E> notImplemented(String message) {
    return new RespBody<>(HttpStatusEnum.NOT_IMPLEMENTED.code(), message, null);
  }

  /**
   * 返回服务不可用的错误
   *
   * @param message 错误描述
   */
  public static <E> RespBody<E> serverUnavailable(String message) {
    return new RespBody<>(HttpStatusEnum.SERVICE_UNAVAILABLE.code(), message, null);
  }

  /**
   * 返回未知错误
   *
   * @param message 错误描述
   */
  public static <E> RespBody<E> unknown(String message) {
    return new RespBody<>(HttpStatusEnum.UNPROCESSABLE_ENTITY.code(), message, null);
  }

  /**
   * 返回自定义错误
   *
   * @param message 错误描述
   */
  public static <E> RespBody<E> customFail(Integer code, String message) {
    return new RespBody<>(code, message, null);
  }
}
