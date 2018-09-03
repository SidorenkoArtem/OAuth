package com.prototype.demo.model.dao;

import lombok.Data;

import javax.persistence.*;

/**
 * DAO model for vendor type.
 */
@Data
@Entity
@Table(name = "vendor_types")
public class VendorTypes {
    /**
     * Vendor type identifier field.
     */
    @Id
    @SequenceGenerator(name = "vendor_type_id_seq", sequenceName = "vendor_type_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_type_id_seq")
    @Column(name = "vendor_type_id")
    private Long vendorTypeId;

    /**
     * Vendor type title field.
     */
    @Column(name = "vendor_type_title")
    private String vendorTypeTitle;
}
