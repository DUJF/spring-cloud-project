package com.github.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author dujf
 * @since 2018-11-08
 */
public class UserInfo extends Model<UserInfo> {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  /**
   * 账号
   */
  private String account;

  /**
   * 角色
   */
  private String role;

  /**
   * 密码
   */
  private String password;

  private String salt;

  /**
   * 状态
   */
  private Integer status;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Override
  protected Serializable pkVal() {
    return this.id;
  }

  @Override
  public String toString() {
    return "UserInfo{" +
        "id=" + id +
        ", account=" + account +
        ", role=" + role +
        ", password=" + password +
        ", salt=" + salt +
        ", status=" + status +
        "}";
  }
}
