package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.Account;
import com.prototype.demo.model.dao.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * CRUD repository for working with transactions table in database.
 */
@Repository
public interface TransactionsRepository extends CrudRepository<Transaction, Long> {
    /**
     * Method return Transaction by QR code.
     * @param qr
     * @return
     */
    Optional<Transaction> findByTransactionQrStringEquals(final String qr);

    /**
     * Method return Transaction by account.
     * @param account
     * @return
     */
    List<Transaction> findByAccountEquals(final Account account);
}
