package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.VendorTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorTypesRepository extends CrudRepository<VendorTypes, Long> {
}
