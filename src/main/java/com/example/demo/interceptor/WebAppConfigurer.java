package com.example.demo.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器.
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer  {
  @Bean
  HandlerInterceptor baseInterceptor() {
    return new BaseInterceptor();
  }

  @Override
  public void addInterceptors(InterceptorRegistry interceptorRegistry) {
    interceptorRegistry.addInterceptor(baseInterceptor());
  }
}
