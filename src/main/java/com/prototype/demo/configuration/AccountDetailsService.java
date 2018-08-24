package com.prototype.demo.configuration;

import com.prototype.demo.model.dao.User;
import com.prototype.demo.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.google.common.collect.ImmutableList;

@Service
@RequiredArgsConstructor
public class AccountDetailsService implements UserDetailsService {

    @Autowired
    private final UsersRepository usersRepository;

    enum enum1 {user}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = usersRepository.findByUsername(username);
        return UserDetail.builder()
                .userId(user.getId())
                .username(user.getName())
                .password(user.getPassword())
                .authorities(ImmutableList.of(new SimpleGrantedAuthority("ROLE_" + enum1.user)))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();

    }
}
