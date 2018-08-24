package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    @Query("SELECT user FROM User user " +
            "WHERE user.name = :username")
    User findByUsername(@Param("username") String username);
}
