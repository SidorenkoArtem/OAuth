package com.prototype.demo.model.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity()
@Table(name = "vendors")
public class Vendor {
    @Id
    @SequenceGenerator(name = "vendor_id_seq", sequenceName = "vendor_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vendor_id_seq")
    @Column(name = "vendor_id")
    private Long vendorId;

    @Column(name = "vendor_name")
    private String vendorName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_type_id")
    private VendorTypes vendorTypes;
}
