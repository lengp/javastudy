package com.example.demo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: LengPeng
 * @Date: 2019/11/4 2:11 PM
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public void errorHandler(Exception ex, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=utf-8");
    PrintWriter out = response.getWriter();
    out.write(ex.getMessage());
    out.flush();
    out.close();
  }
}
