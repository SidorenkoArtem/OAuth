package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByPhoneEquals(final String phone);
}
