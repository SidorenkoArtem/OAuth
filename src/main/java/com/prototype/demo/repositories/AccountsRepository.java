package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.Account;
import com.prototype.demo.model.dao.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * CRUD repository for working with account table in database.
 */
@Repository
public interface AccountsRepository extends CrudRepository<Account, Long> {
    /**
     * Method return Account by user.
     * @param user
     * @return
     */
    Optional<Account> findByUserEquals(final User user);
}
