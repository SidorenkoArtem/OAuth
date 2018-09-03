package com.prototype.demo.model.dao;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * DAO model for transaction.
 */
@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    /**
     * Transaction identifier field.
     */
    @Id
    @SequenceGenerator(name = "transaction_id_seq", sequenceName = "transaction_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_seq")
    @Column(name = "transaction_id")
    private Long transactionId;

    /**
     * Account field.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    /**
     * Counterparty account field.
     */
    @Column(name = "counterparty_account_id")
    private Integer counterPartyAccountId;

    /**
     * Transaction amount field.
     */
    @Column(name = "transaction_amount")
    private Integer transactionAmount;

    /**
     * Transaction date field.
     */
    @Column(name = "transaction_date")
    private LocalDateTime transactionDate = LocalDateTime.now();

    /**
     * Transaction status field.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_status")
    private TransactionStatus transactionStatus;

    /**
     * Transaction subject field.
     */
    @Column(name = "transaction_subject")
    private String transactionSubject;

    /**
     * Transaction currency field.
     */
    @Column(name = "transaction_currency")
    private String transactionCurrency;

    /**
     * Transaction qr string code field.
     */
    @Column(name = "transaction_qr_string")
    private String transactionQrString;
}
