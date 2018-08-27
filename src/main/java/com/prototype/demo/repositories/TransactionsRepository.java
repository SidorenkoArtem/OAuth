package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionsRepository extends CrudRepository<Transaction, Long> {
    Optional<Transaction> findByTransactionQrStringEquals(final String qr);
}
