package com.stdstack.service.course.courseservice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.experimental.Wither;

import javax.servlet.http.HttpServletRequest;

public final class JwtUtil {

    public static Claims claimsFromRequest(HttpServletRequest req) {
        String header = req.getHeader("Authorization");
        header = header.replace("Bearer ", "");
        Claims claims = Jwts.parser()
                .setSigningKey("123".getBytes()) //todo
                .parseClaimsJws(header).getBody();
        return claims;
    }
}
