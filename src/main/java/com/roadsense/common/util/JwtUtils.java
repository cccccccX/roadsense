package com.roadsense.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * author  Edith
 * created  2023/12/27 22:07
 */
public class JwtUtils {

    /**
     *生成jwt
     * 使用Hs256算法, 私匙使用固定秘钥
     * @param secretKey
     * @param ttlMillis
     * @param calims
     * @return
     */
    public static String createJWT(String secretKey, long ttlMillis, Map<String, Object> calims) {

        long expMillis = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expMillis);

        String jwt = Jwts.builder()
                .setClaims(calims)
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes(StandardCharsets.UTF_8))
                .setExpiration(exp)
                .compact();
        return jwt;

    }

    /**
     * Token解密
     *
     * @param secretKey jwt秘钥 此秘钥一定要保留好在服务端, 不能暴露出去, 否则sign就可以被伪造, 如果对接多个客户端建议改造成多个
     * @param token     加密后的token
     * @return
     */
    public static Claims parseJWT(String secretKey, String token){
        Claims body = Jwts.parser()
                .setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
        return body;
    }

}
