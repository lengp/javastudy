package com.example.demo.controller;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

  @GetMapping("/hello")
  public String helloWorld() {
    return "Hello world!" + LocalDateTime.now().toString();
  }
}
