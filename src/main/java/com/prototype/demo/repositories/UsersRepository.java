package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    Optional<User> findByPhoneEquals(final String phone);
}
