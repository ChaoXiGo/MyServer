package com.chaoxi.myserver.config.handler;

import com.chaoxi.myserver.pojo.R;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * 自定义拦截器
 */
@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            /* Authorization authorization = handlerMethod.getMethodAnnotation(Authorization.class);
            Method method = handlerMethod.getMethod();
            log.info("authorization" + authorization); */

            String token = request.getHeader("token");
            if (token == null){
                outputStream(response, R.error("没有token"));
                return false;
            }
        }
        // String requestURI = request.getRequestURI();
        // log.info("requestURI" + requestURI);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 向客户端返回响应信息（json格式）
     */
    private void outputStream(HttpServletResponse servletResponse, R response) {
        try {
            Gson gson = new Gson();
            String s = gson.toJson(response);

            // String string = JSON.toJSONString(JSONResponse.info(message));
            servletResponse.setContentType("application/json;charset=UTF-8");
            servletResponse.getOutputStream().write(s.getBytes(StandardCharsets.UTF_8));
            servletResponse.getOutputStream().close();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
