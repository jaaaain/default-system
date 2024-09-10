package com.jaaaain.defaultsystem.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static String signKey="cjnssjszhkdrwcnyszmxdbgjdxhcjnhhhhhhhhhhhhhhhhhhhhhhhhhh";
    private static Long expire=43200000L;
    private static SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(signKey));

    public static String generateJwt(Map<String, Object> claims) {
        String jwt = Jwts.builder()
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis()+expire))
                .signWith(secretKey,Jwts.SIG.HS256)
                .compact();
        return jwt;
    }

    /**
     * 使用密钥和算法解析JWT
     * @param jwtToken
     * @return
     */
    public static Claims parseJwt(String jwtToken) {
        try {
            // 使用密钥和算法解析JWT

            Claims claims =Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(jwtToken) //传递jwt令牌参数
                    .getPayload();

            // 校验令牌是否过期
            Date expiration = claims.getExpiration();
            if (expiration != null && expiration.before(new Date())) {
                throw new SecurityException("JWT令牌已过期");
            }

            return claims; // 如果校验通过，则返回Claims对象
        } catch (Exception e) {
            // 处理异常，比如令牌格式错误、签名不匹配、令牌过期等
            throw new RuntimeException("JWT令牌无效", e);
        }
    }
}
