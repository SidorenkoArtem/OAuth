package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.Account;
import com.prototype.demo.model.dao.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends CrudRepository<Account, Long> {
    @Query("select account from Account account left join account.user user where account.user = ?1")
    Optional<Account> findByUser(final User user);
}
