package com.example.demo.controller;

import com.example.demo.model.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LengPeng
 * @Date: 2019/10/22 2:40 PM
 */
@RestController
public class TestController {

  @GetMapping("/users")
  public List<User> getUsers(){
    List<User> users = new ArrayList<>();
    for (int i=0;i<5;i++){
      User user = new User();
      user.setId(i);
      user.setName("hello>>"+i);
      user.setBirthday(new Date());
      users.add(user);
    }
    return users;
  }
}
