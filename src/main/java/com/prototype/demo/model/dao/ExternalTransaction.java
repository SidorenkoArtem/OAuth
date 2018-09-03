package com.prototype.demo.model.dao;

import lombok.Data;

import javax.persistence.*;

/**
 * DAO model for external transaction.
 */
@Data
@Entity
@Table(name = "external_transactions")
public class ExternalTransaction {

    /**
     * External transactional identifier field.
     */
    @Id
    @SequenceGenerator(name = "external_transactional_id_seq", sequenceName = "external_transactional_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "external_transactional_id_seq")
    @Column(name = "external_transactional_id")
    private Long externalTransactionalId;

    /**
     * Transaction field.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    /**
     * External transaction status field.
     */
    @Column(name = "external_transaction_status")
    private String externalTransactionStatus;
}
