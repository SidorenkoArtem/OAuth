package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD repository for working with vendors table in database.
 */
@Repository
public interface VendorsRepository extends CrudRepository<Vendor, Long> {
}
