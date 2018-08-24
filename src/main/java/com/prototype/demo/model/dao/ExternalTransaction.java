package com.prototype.demo.model.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "external_transactions")
public class ExternalTransaction {

    @Id
    @SequenceGenerator(name = "external_transactional_id_seq", sequenceName = "external_transactional_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "external_transactional_id_seq")
    @Column(name = "external_transactional_id")
    private Long externalTransactionalId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @Column(name = "external_transaction_status")
    private String externalTransactionStatus;
}
