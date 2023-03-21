package com.example.jwttest.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class JwtTokenizer {

    // Plain Test형태인 Secret Key의 byte[]를 base64형식의 문자열로 인코딩
    public String encodeBase64SecretKey(String secretKey){
        return Encoders.BASE64.encode(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    // 인증된 사용자에게 jwt를 최초로 발급해주기 위한 Jwt생성 메서드
    public String generateAccessToken(Map<String, Object> claims,
                                      String subject,
                                      Date expiration,
                                      String base64EncodedSecretKey){
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey); //Base64형식 Secret Key문자열을 이용해 Key객체

        return Jwts.builder()
                .setClaims(claims)  //jwt에 포함시킬 custom claims 추가 여기엔 주로 인증된 사용자와 관련된 정보 추가
                .setSubject(subject) //jwt에 대한 제목 추가
                .setIssuedAt(Calendar.getInstance().getTime()) //jwt발행 일자 설정
                .setExpiration(expiration) //jwt 만료일시 설정
                .signWith(key) //서명을 위한 key 설정
                .compact(); //jwt 생성 및 직렬화
    }

    //Access Token이 만료되었을 경우 새로 생성 하는 RefreshToken 메서드
    public String generateRefreshToken(String subject, Date expiration, String base64EncodedSecretKey){
        Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(Calendar.getInstance().getTime())
                .signWith(key)
                .compact();
    }

    //검증
    public void verifySignature(String jws, String base64EncodedSecretKey) {
            Key key = getKeyFromBase64EncodedKey(base64EncodedSecretKey);

            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jws);
        }

    //jwt의 서명에 사용할 Secret Key 생성
    private Key getKeyFromBase64EncodedKey(String base64EncodedSecretKey){
        byte [] keyBytes = Decoders.BASE64.decode(base64EncodedSecretKey); //Base64형식으로 인코딩된 SecretKey 디코딩후 byteArray 반환
        Key key = Keys.hmacShaKeyFor(keyBytes); //key byte array를 기반으로 적절한 hmac 알고리즘을 적용한 key 객체 생성
        return key;

    }

}
