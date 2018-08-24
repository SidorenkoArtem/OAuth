package com.prototype.demo.model.dao;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @SequenceGenerator(name = "transaction_id_seq", sequenceName = "transaction_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_seq")
    @Column(name = "transaction_id")
    private Long transactionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "counterparty_account_id")
    private Integer counterPartyAccountId;

    @Column(name = "transaction_amount")
    private Integer transactionAmount;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_status")
    private TransactionStatus transactionStatus;

    @Column(name = "transaction_subject")
    private String transactionSubject;

    @Column(name = "transaction_currency")
    private String transactionCurrency;

    @Column(name = "transaction_qr_string")
    private String transactionQrString;
}
