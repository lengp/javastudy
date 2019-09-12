package com.example.demo.interceptor;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

/**
 * 拦截器.
 */
public class BaseInterceptor implements HandlerInterceptor {

  Map getUriTemplateVariables(final HttpServletRequest request) {

    Map uriTemplateVariableMap = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

    return uriTemplateVariableMap;
  }

  @Override
  public boolean preHandle(final HttpServletRequest request,
                           final HttpServletResponse response,
                           final Object handler) {
    String method = request.getMethod();
    String para = request.getParameter("id");
    Map map = getUriTemplateVariables(request);
    if (map.containsKey("id")) {

    }
    return true;
  }
}
