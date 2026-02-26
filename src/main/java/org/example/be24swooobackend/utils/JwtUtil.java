package org.example.be24swooobackend.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    static String key = "sdfkhgsdkglnhoiurjdfoihgh397478thgwr390289gyrfhp90823uoevbdo823uvh4tf";
    static SecretKey encodedKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));

    public static String createToken(Long idx, String email, String name, String role) {
        String jwt = Jwts.builder()
                .claim("idx", idx)
                .claim("email", email)
                .claim("name", name)
                .claim("role", role)
                .issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + 300000)).signWith(encodedKey).compact();

        return jwt;
    }

    private static Claims getClaims(String token) {
        return Jwts.parser()
                .verifyWith(encodedKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public static Long getUserIdx(String token) {
        return getClaims(token).get("idx", Long.class);
    }

    public static String getEmail(String token) {
        return getClaims(token).get("email", String.class);
    }

    public static String getName(String token) {
        return getClaims(token).get("name", String.class);
    }

    public static String getRole(String token) {
        return getClaims(token).get("role", String.class);
    }
}
