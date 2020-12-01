package edu.njust.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("curUser");
        if(loginUser == null){
            request.setAttribute("msg","无权限，请登录");
            request.getRequestDispatcher("/sign-in.html").forward(request,response);
            return false;
        }
        return true;
    }
}
