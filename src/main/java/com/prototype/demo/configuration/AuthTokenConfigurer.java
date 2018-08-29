package com.prototype.demo.configuration;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class AuthTokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private UserDetailsService detailsService;

    public AuthTokenConfigurer(UserDetailsService detailsService) {
        this.detailsService = detailsService;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        AuthTokenFilter customFilter = new AuthTokenFilter(detailsService);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
