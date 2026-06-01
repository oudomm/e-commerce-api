package dev.oudom.webmvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Configure security with user in database
    @Bean
    public DaoAuthenticationProvider daoAuthProvider(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Bean
    public SecurityFilterChain apiSecurity(HttpSecurity http) {
        // TODO: define your security configuration
        // 1. Security Mechanism -> HTTP Basic Authentication (username & password)
        http.httpBasic(Customizer.withDefaults());

        // 2. Session Stateless
        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // 3. Endpoints security
        http.authorizeHttpRequests(endpoint -> endpoint
                .requestMatchers(HttpMethod.POST, "/api/v1/products/**").hasAnyRole("BUSINESS", "ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/v1/products/**").hasAnyRole("BUSINESS", "ADMIN")
                .requestMatchers(HttpMethod.PATCH, "/api/v1/products/**").hasAnyRole("BUSINESS", "ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/products/**").hasAnyRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/v1/products/**").permitAll()
                .anyRequest().authenticated()
        );

        // 4. Disable CSRF token
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
