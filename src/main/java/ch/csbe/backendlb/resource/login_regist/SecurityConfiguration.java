package ch.csbe.backendlb.resource.login_regist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    // Konfiguriert die Sicherheit Filterkette für die Anwendung.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
    throws Exception {
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        // Deaktiviert CSRF.
        http.csrf().disable();
        http
            .httpBasic().disable()
            .authorizeHttpRequests((authz) -> authz
                 // Definiert Zugriffsberechtigungen für Endpoints und Ressourcen.
                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .requestMatchers(HttpMethod.GET, "/demo/open").permitAll()
                .requestMatchers("/swagger-ui/index.html").permitAll()
                .requestMatchers("/user/{id}/promote").hasAuthority("ROLE_ADMIN")
                .requestMatchers("/swagger-ui/*").permitAll()
                .requestMatchers("/v3/api-docs").permitAll()
                .requestMatchers("/user/{id}").permitAll()
                .requestMatchers("/products").permitAll()
                .requestMatchers("/products/{id}").permitAll()
                .requestMatchers("/productscategories/{id}").permitAll()
                .requestMatchers("/productscategories").permitAll()
                .requestMatchers("productscategories/{name}/products").permitAll()
                .requestMatchers("/v3/api-docs/swagger-config").permitAll()
                .requestMatchers(HttpMethod.POST, "/authenticate/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/authenticate/register").permitAll()
                .anyRequest().authenticated()
        );

        return http.build();
    }

}
