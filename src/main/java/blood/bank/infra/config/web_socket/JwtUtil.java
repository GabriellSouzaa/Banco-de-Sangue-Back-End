package blood.bank.infra.config.web_socket;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;

public class JwtUtil {


    public static String extractUsername(String token){
        return getClaims(token).getSubject();
    }

    private static Claims getClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private static Key getSigningKey(){
        String secret = "GJMdO3DfUsG5eY3+t5DgUj0PLbKH2Gf6X3z1yTb9w9c=";
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }
}
