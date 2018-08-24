package com.prototype.demo.repositories;

import com.prototype.demo.model.dao.Vendor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorsRepository extends CrudRepository<Vendor, Long> {
}
