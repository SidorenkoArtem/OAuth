package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.Account;
import com.prototype.demo.model.dao.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends CrudRepository<Account, Long> {
    Optional<Account> findByUserEquals(final User user);
}
