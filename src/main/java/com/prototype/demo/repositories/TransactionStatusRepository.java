package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.TransactionStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD repository for working with transaction status table in database.
 */
@Repository
public interface TransactionStatusRepository extends CrudRepository<TransactionStatus, Long> {
}
