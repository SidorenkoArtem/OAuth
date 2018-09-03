package com.prototype.demo.configuration;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Class where override filter chain of GenericFilterBean class.
 */
public class AuthTokenFilter extends GenericFilterBean {

    /**
     * Inject: UserDetailsService, TokenUtils
     */
    private final UserDetailsService detailsService;
    private final TokenUtils tokenUtils = new TokenUtils();
    private String AuthTokenHeaderName = "x-auth-token";

    /**
     * Initialisation details service
     * @param userDetailsService
     */
    public AuthTokenFilter(UserDetailsService userDetailsService) {
        this.detailsService = userDetailsService;
    }

    /**
     * Override doFilter of GenericFilterBean. Custom filter token validation and set token to security context holder.
     * @param arg0
     * @param arg1
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) arg0;
            String authToken = httpServletRequest.getHeader(this.AuthTokenHeaderName);

            if (StringUtils.hasText(authToken)) {
                String username = this.tokenUtils.getUserNameFromToken(authToken);

                UserDetails details = this.detailsService.loadUserByUsername(username);

                if (this.tokenUtils.validateToken(authToken, details)) {
                    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(details, details.getPassword(), details.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(token);
                }
            }
            filterChain.doFilter(arg0, arg1);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}