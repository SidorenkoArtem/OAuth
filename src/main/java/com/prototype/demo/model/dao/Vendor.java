package com.prototype.demo.model.dao;

import lombok.Data;
import javax.persistence.*;

/**
 * DAO model for vendor.
 */
@Data
@Entity()
@Table(name = "vendors")
public class Vendor {
    /**
     * Vendor identifier field.
     */
    @Id
    @SequenceGenerator(name = "vendor_id_seq", sequenceName = "vendor_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_id_seq")
    @Column(name = "vendor_id")
    private Long vendorId;

    /**
     * Vendor name field.
     */
    @Column(name = "vendor_name")
    private String vendorName;

    /**
     * Vendor type identifier field.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_type_id")
    private VendorTypes vendorTypes;
}
