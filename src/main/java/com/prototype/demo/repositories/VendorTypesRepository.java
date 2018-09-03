package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.VendorTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD repository for working with vendor types table in database.
 */
@Repository
public interface VendorTypesRepository extends CrudRepository<VendorTypes, Long> {
}
