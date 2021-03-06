package com.prototype.demo.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import com.prototype.demo.configuration.TokenUtils;

import com.prototype.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserAuthTokenController {

    /**
     * Pull up token utils.
     */
    private final TokenUtils tokenUtils = new TokenUtils();
    /**
     * Inject: AuthenticationManager, UserService, UserDetailsService through constructor.
     */
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserDetailsService userDetailsService;


    /**
     * Method for authentication user by username and password and grant rights.
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/authenticate", method = { RequestMethod.POST })
    public UserTransfer authorize(@RequestParam String username, @RequestParam String password) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = this.authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails details = userDetailsService.loadUserByUsername(username);
        Map<String, Boolean> roles = new HashMap<String, Boolean>();
        for (GrantedAuthority authority : details.getAuthorities())
            roles.put(authority.toString(), Boolean.TRUE);

        return new UserTransfer(details.getUsername(), roles, tokenUtils.createToken(details));
    }

    /**
     * Class that transfer user with min information.
     */
    public static class UserTransfer {

        private final String name;
        private final Map<String, Boolean> roles;
        private final String token;

        public UserTransfer(String userName, Map<String, Boolean> roles, String token) {

            Map<String, Boolean> mapOfRoles = new ConcurrentHashMap<>();
            for (String k : roles.keySet())
                mapOfRoles.put(k, roles.get(k));

            this.roles = mapOfRoles;
            this.token = token;
            this.name = userName;
        }

        public String getName() {
            return this.name;
        }

        public Map<String, Boolean> getRoles() {
            return this.roles;
        }

        public String getToken() {
            return this.token;
        }
    }
}
