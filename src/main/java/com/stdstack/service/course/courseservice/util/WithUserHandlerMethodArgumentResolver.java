package com.stdstack.service.course.courseservice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class WithUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(WithUser.class) &&
                parameter.getParameterType().equals(UserInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest httpServletRequest = (HttpServletRequest) webRequest.getNativeRequest();

        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        if (authorizationHeader == null) return null; //to local
        authorizationHeader = authorizationHeader.replace("Bearer ", "");
        Claims claims = Jwts.parser()
                .setSigningKey("123".getBytes()) //todo just example
                .parseClaimsJws(authorizationHeader).getBody();
        String name = (String) claims.get("user_name");
        return new UserInfo(name);
    }
}
