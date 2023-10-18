package com.chaoxi.myserver.filter;


import com.chaoxi.myserver.utils.JwtUtils;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.chaoxi.myserver.utils.JwtUtils.TOKEN_INVALID;

/**
 * 使用之前在Config文件添加 @ServletComponentScan
 * 过滤器，如果是登录或者注册请求不需要检查token，其它情况判断token， 失效转发到登录界面， 有效生成新的token返回
 */
// @WebFilter("/app/*")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取请求的URL
        String requestURI = request.getRequestURI();

        // 检查请求的URL是否是/app/login或/app/register
        if ("/app/login".equals(requestURI) || "/app/register".equals(requestURI)) {
            // 如果是登录或注册请求，继续执行过滤器链
            filterChain.doFilter(request, response);
        } else {
            // 如果不是登录或注册请求，检查token
            String token = request.getHeader("token");
            if (token == null) {
                outputStream(servletResponse, "未登录，无法访问");
                return; // 结束过滤器，避免进一步处理
            }
            String result = JwtUtils.verifyToken(token);
            if (result.equals(TOKEN_INVALID)) {
                // 设置响应头状态401,不继续执行
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401 Unauthorized
                outputStream(servletResponse, "令牌已失效");
            } else {
                String newToken = JwtUtils.refreshToken(token);
                response.setHeader("token", newToken);
                response.setDateHeader("expire",JwtUtils.EXPIRE_DATE);
                // 继续执行过滤器链，将请求传递给下一个过滤器或Servlet
                filterChain.doFilter(request, response);
            }
        }
    }

    /**
     * 向客户端返回响应信息（json格式）
     */
    private void outputStream(ServletResponse servletResponse, String message) {
        try {
            Gson gson = new Gson();
            String s = gson.toJson(message);

            // String string = JSON.toJSONString(JSONResponse.info(message));
            servletResponse.setContentType("application/json;charset=UTF-8");
            servletResponse.getOutputStream().write(s.getBytes("UTF-8"));
            servletResponse.getOutputStream().close();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
