package ch.csbe.backendlb.resource.login_regist;

import ch.csbe.backendlb.resource.user.UserEntitie;
import ch.csbe.backendlb.resource.user.UserService;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
    public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    private final String SECRET_KEY = "yourMoreSecretKey";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {
        //überprüft ob request einen authorizationHeader enthält
        final String authorizationHeader = request.getHeader("Authorization");

        String email = null;
        String jwt = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
            email = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody().getSubject();
        }

        // Schaut ob benutzer breits autentifizirt ist
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Benutzer anhand der Email abrufen
            UserEntitie user = userService.findUserByEmail(email);
            MyUserPrincipal userPrincipal = new MyUserPrincipal(user);
            userPrincipal.setEmail(user.getEmail());
            // Erstelt ein Authentifizirungs Token
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
            // Benutzer in Sicherheitskontext enfügen
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        // eiter zum nächsten Filter
        chain.doFilter(request, response);
    }
}
