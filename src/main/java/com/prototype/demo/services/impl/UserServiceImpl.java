package com.prototype.demo.services.impl;

import com.prototype.demo.exeptions.UserNotExistsException;
import com.prototype.demo.model.dao.User;
import com.prototype.demo.model.requests.UserRequest;
import com.prototype.demo.model.responses.UserResponse;
import com.prototype.demo.repositories.UsersRepository;
import com.prototype.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Service implementation for working with user service data model.
 */
@Service()
public class UserServiceImpl implements UserService {

    /**
     * Inject: UsersRepository
     */
    @Autowired
    private UsersRepository usersRepository;

    /**
     * Method return user details by username
     * @param userId
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String userId) {
        final User user = usersRepository.findByUsername(userId).orElseThrow(UserNotExistsException::new);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }

    /**
     * Method return list granted authority
     * @return
     */
    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        usersRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    /**
     * Delete user by user identifier.
     */
    @Override
    public void delete(final long id) {
        final User user = usersRepository.findById(id)
                .orElseThrow(UserNotExistsException::new);
        usersRepository.delete(user);
    }

    /**
     * Method return user response after creating record.
     * @param userRequest
     * @return
     */
    @Override
    public UserResponse createUser(final UserRequest userRequest) {
        final UserResponse userResponse = new UserResponse();
        final User user = new User();
        user.setPassword(userRequest.getPassword());
        user.setPhone(userRequest.getPhone());
        user.setUsername(userRequest.getName());
        usersRepository.save(user);
        userResponse.setUser(user);
        return userResponse;
    }

    /**
     * Method save entity user in database.
     * @param user
     * @return
     */
    @Override
    public User save(User user) {
        return usersRepository.save(user);
    }
}
