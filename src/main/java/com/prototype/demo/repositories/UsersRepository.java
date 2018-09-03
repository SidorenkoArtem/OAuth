package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * CRUD repository for working with users table in database.
 */
@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByPhoneEquals(final String phone);
}
