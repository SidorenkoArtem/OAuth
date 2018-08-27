package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends CrudRepository<Account, Long> {
    @Query("select account from Account account left join account.user user where account.")
    Optional<Account> findBy(final String phoneNumber);
}
