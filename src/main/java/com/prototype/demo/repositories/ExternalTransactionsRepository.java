package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.ExternalTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExternalTransactionsRepository extends CrudRepository<ExternalTransaction, Long> {
}
