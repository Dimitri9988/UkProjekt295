package ch.csbe.backendlb.resource.login_regist;

import ch.csbe.backendlb.resource.user.UserEntitie;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    //Geheimer Schlüssel zur Signirung des Tokens
    private final String SECRET_KEY = "yourMoreSecretKey";

    // Erstelt Token für den angegeben benutzer
    public String generateToken(UserEntitie user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
