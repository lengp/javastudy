package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @Author: LengPeng
 * @Date: 2019/10/22 2:58 PM
 */
public class User {
  private Integer id;
  private String name;
  @JsonFormat(pattern = "yyyy-mm-dd")
  private Date birthday;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }
}
