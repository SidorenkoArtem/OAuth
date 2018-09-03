package com.prototype.demo.model.dao;

import lombok.Data;
import javax.persistence.*;

/**
 * DAO model for account entity
 */
@Data
@Entity
@Table(name = "accounts")
public class Account {
    /**
     * Account identifier field
     */
    @Id
    @SequenceGenerator(name = "account_id_seq", sequenceName = "account_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_id_seq")
    @Column(name = "account_id")
    private Long accountId;

    /**
     * User field.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    /**
     * Account name field.
     */
    @Column(name = "account_name")
    private String accountName;

    /**
     * Vendor identifier field.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    /**
     * Account vendor number field.
     */
    @Column(name = "account_vendor_number")
    private String accountVendorNumber;
}
