package com.roadsense.interceptor;

import com.roadsense.common.constant.JwtClaimsConstant;
import com.roadsense.common.context.BaseContext;
import com.roadsense.common.properties.JwtProperties;
import com.roadsense.common.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author  Edith
 * created  2023/12/27 22:45
 */
@Component
@Slf4j
public class JwtTokenInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtProperties jwtProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断当前拦截到的是Controller的方法还是其他资源
        if (!(handler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接放行
            return true;
        }

        String token = request.getHeader(jwtProperties.getTokenName());

        try {
            log.info("开始解析token: {}", token);
            Claims claims = JwtUtils.parseJWT(jwtProperties.getSecretkey(), token);
            Object userId = claims.get(JwtClaimsConstant.USER_ID);
            log.info("获取userId: {}", userId);
//            Long.valueOf(userId.toString())
            BaseContext.setCurrentId(Long.valueOf(userId.toString()));
            return true;
        }catch (Exception ex){
            response.setStatus(401);
            System.out.println(ex);
            log.error("登录失败, {}", ex.getMessage());
            return false;
        }
    }
}
