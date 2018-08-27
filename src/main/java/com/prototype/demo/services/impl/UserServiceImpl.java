package com.prototype.demo.services.impl;

import com.prototype.demo.model.dao.User;
import com.prototype.demo.repositories.UsersRepository;
import com.prototype.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(userId);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        usersRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(final long id) {
        final User user = usersRepository.findById(id).orElse(null);
        usersRepository.delete(user);
    }

    @Override
    public User save(User user) {
        return usersRepository.save(user);
    }
}
