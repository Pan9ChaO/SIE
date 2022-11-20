package com.fran.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");

        Object loginStu = request.getSession().getAttribute("loginStu");
        if(loginStu == null || loginUser !=null){
            request.setAttribute("msg","No permission, please log in first !");
//            request.getRequestDispatcher("/index.html").forward(request,response);
            request.getRequestDispatcher("/login_stu.html").forward(request,response);
            return false;
        }else{
            return true;
        }


    }
}
