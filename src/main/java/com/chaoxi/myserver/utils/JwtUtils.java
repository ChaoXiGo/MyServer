package com.chaoxi.myserver.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class JwtUtils {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private static String secret = "a1g2y47dg3dj59fjhhsd7cnewy73ja1g2y47dg3dj59fjhhsd7cnewy73j";

    private long expire;
    private String header;

    // 设置过期时间（毫秒为单位）
    public static final long EXPIRE_DATE = 10 * 60 * 1000;
    // token秘钥（可以自定义一个随机字符串就行，避免中文）
    private static final String TOKEN_SECRET = "a1g2y47dg3dj59fjhhsd7cnewy73ja1g2y47dg3dj59fjhhsd7cnewy73j";


    public static final String TOKEN_VALID = "有效";
    public static final String TOKEN_INVALID = "无效";

    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DATE))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS256, TOKEN_SECRET)
                .compact();
        /* return Jwts.builder()
                .setClaims(claims)
                // 登录用户的id
                .setId(String.valueOf(userId))
                // 登录用户的名称
                .setSubject(mobile)
                // 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + 30 * 1000))
                // 当前时间
                .setIssuedAt(new Date(System.currentTimeMillis()))
                // 头部信息 第一个参数为加密方式为哈希512  第二个参数为加的盐为secret字符串
                .signWith(SignatureAlgorithm.HS256, this.secret)
                .compact(); */

    }

    /**
     * 初始化生成token的参数
     *
     * @param userId
     * @return String
     */
    public static String generateToken(String userId) {
        Map<String, Object> claims = new HashMap<>(1);
        claims.put("sub", userId);
        return generateToken(claims);
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(this.secret)
                    .parseClaimsJws(token)
                    .getBody();
            final Date iat = claims.getIssuedAt();
            final Date exp = claims.getExpiration();
            if (iat.before(lastPasswordReset) || exp.before(new Date(System.currentTimeMillis()))) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新 生成新的token
     */
    public static String refreshToken(String token) {
        // String refreshedToken;
        try {
            final Claims claims = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
            return generateToken(claims);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 检查token
     *
     * @param token
     * @return
     */
    public static String verifyToken(String token) {
        String result = "";
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(TOKEN_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
            // final Date iat = claims.getIssuedAt();
            // final Date exp = claims.getExpiration();
            result = TOKEN_VALID;
        } catch (Exception e) {
            result = TOKEN_INVALID;
        }
        return result;
    }

    public String getToken(String mobile, String password, Long userId) {
        try {
            // 过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_DATE);
            // 秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>();
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            // 携带username，password和用户ID信息，生成签名，按照需求而定
            return JWT.create()
                    .withHeader(header)
                    .withClaim("mobile", mobile).withClaim("userId", userId)
                    .withClaim("password", password).withExpiresAt(date)
                    .sign(algorithm);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 校验Token是否过期
     */
   /*  public static boolean verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    } */
    public Claims getClaimByToken(String str) {
        try {
            return Jwts.parser().
                    setSigningKey(TOKEN_SECRET).
                    parseClaimsJws(str).
                    getBody();
        } catch (Exception e) {
            this.logger.debug("validate is token error ", (Throwable) e);
            return null;
        }
    }

}
