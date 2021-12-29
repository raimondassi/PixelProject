package com.pixel.pixelproject.config;

import com.pixel.pixelproject.security.JwtAuthenticationFilter;
import com.pixel.pixelproject.security.JwtAuthorizationFilter;
import com.pixel.pixelproject.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    public SecurityConfig(
            UserDetailsService userDetailsService, JwtService jwtService) {
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf() //cross-site request forgery
                    .disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // without session
                .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/api/picture","/swagger-ui/**", "/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html**", "/webjars/**")
                        .permitAll()
                    .antMatchers(HttpMethod.POST,"/api/createuser","/api/picture")
                        .permitAll()
                    .anyRequest()
                        .authenticated()
                .and()
                .exceptionHandling()
                    .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), jwtService))
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), jwtService));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());

    }


}
