package com.start.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;


//@Component
public class JwtUtils {
    // 使用@Value获取application.properties中的配置取值
//    @Value("${jwt.secret}")
    private static String secret = "startfromsdu123fgs";
    private static String tokenPrefix = "JWT ";
    /**
     * 生成token
     * @author yanglingcong
     * @date 2021/12/31 11:23 AM
     * @param map
     * @return String
     */
    public static String generateToken(Map<String, String> map, Integer expires_in)
    {
        System.out.println("secret "+secret);
        Calendar instance = Calendar.getInstance();
        //默认expires_in天过期
        instance.add(Calendar.DATE, expires_in);
        //创建JWT
        JWTCreator.Builder builder = JWT.create();

        //payload
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        //指定令牌过期时间
        builder.withExpiresAt(instance.getTime());

        String token=builder.sign(Algorithm.HMAC256(secret));
        return token;
    }

    /**
     * 验证token
     * @author yanglingcong
     * @date 2021/12/31 11:26 AM
     * @param token
     */
    public static DecodedJWT verifyToken(String token) {
        token = token.replace(tokenPrefix, "");
        System.out.println(token);
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
    }
}
