package com.example.middleware.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class APILoggingInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userAgent = request.getHeader("User-Agent");

        if (userAgent != null) {
            System.out.println("User-Agent: " + userAgent);
        } else {
            System.out.println("User-Agent header is missing");
        }
        long startTime = System.currentTimeMillis();
        System.out.println("Request URL::" + request.getRequestURL().toString() + ":: Start time=" + System.currentTimeMillis());
        request.setAttribute("startTime", startTime);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("Request URL::" + request.getRequestURL().toString() + " Sent to handler :: Current Time=" + System.currentTimeMillis());
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        System.out.println("Request URL::" + request.getRequestURL().toString() + ":: End Time=" + System.currentTimeMillis());
        System.out.println("Request URL::" + request.getRequestURL().toString() + ":: Time Taken=" + (System.currentTimeMillis() - startTime));

        if (ex != null) {
            System.out.println("Exception: " + ex.getMessage());
            ex.getStackTrace();
        }
    }

}
