package services.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import services.JwtService;
import utils.Utils;

@Service
@Slf4j
public class JwtServiceImpl implements JwtService {

    @Value("${application.jwt.decodeKey}")
    private String secretKey;

    @Override
    public String getUsername(String token) {
        try {
            Claims body = getClaims(token).getBody();
            return body.getSubject();
        } catch (Exception ex) {
            log.error(ex.toString());
            return null;
        }
    }

    public boolean validate(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception ex) {
            log.error("Token is not valid");
            return false;
        }
    }

    private Jws<Claims> getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(Utils.formatToken(token));
    }
}
