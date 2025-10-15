package com.itheima.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Result;
import com.itheima.pojo.entity.User;
import com.itheima.utils.JwtUtil;
import com.itheima.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserMapper userMapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Checking login authorization");
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty() || !jwtUtil.validateToken(token) || jwtUtil.isTokenExpired(token)) {
            log.info("Token is invalid");

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");

            Result result = Result.error("Token is invalid");
            String json = objectMapper.writeValueAsString(result);

            response.getWriter().write(json);
            return false;
        }
        String username = jwtUtil.getUsernameFromToken(token);
        User user = userMapper.findByUsername( username);
        if (user == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");

            Result result = Result.error("Token is invalid");
            String json = objectMapper.writeValueAsString(result);

            response.getWriter().write(json);
            return false;
        }
        ThreadLocalUtil.set(username);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }

}
