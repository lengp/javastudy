package com.example.demo.controller;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * rest接口.
 */
@RestController
public class HelloWorld {

  @GetMapping("/hello")
  public String helloWorld() {
    return "Hello world!" + LocalDateTime.now().toString();
  }

  @GetMapping("/hello/{id}")
  public String helloWorldById(@PathVariable String id) {
    return "Hello world!" + LocalDateTime.now().toString() + "===" + id;
  }
}
