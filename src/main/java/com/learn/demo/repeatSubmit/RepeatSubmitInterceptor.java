package com.learn.demo.repeatSubmit;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.UUID;

@Slf4j
public class RepeatSubmitInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod handlerMethod = null;
        try {
            handlerMethod = (HandlerMethod)handler;
        } catch (Exception e) {
            return true;
        }
        Method method = handlerMethod.getMethod();

        Token token = method.getAnnotation(Token.class);
        if(token != null ){
            boolean saveSession = token.save();
            if(saveSession){
                request.getSession(true).setAttribute("token", UUID.randomUUID());
            }

            boolean removeSession = token.remove();
            if(removeSession){
                if(isRepeatSubmitSession(request)){
                    log.info("repeat submit session :" + request.getServletPath());
                    response.sendRedirect("/error/409");
                    return false;
                }
                request.getSession(true).removeAttribute("token");
            }
        }
        return true;
    }

    private boolean isRepeatSubmitSession(HttpServletRequest request){
        String sessionToken = String.valueOf(request.getSession(true).getAttribute("token") == null ? "" : request.getSession(true).getAttribute("token"));
        String clientToken =  String.valueOf(request.getParameter("token") == null ? "" : request.getParameter("token"));
        if(sessionToken == null || sessionToken.equals("")){
            return true;
        }
        if(clientToken == null || clientToken.equals("")){
            return true;
        }
        if(!sessionToken.equals(clientToken)){
            return true;
        }
        return false;
    }

}