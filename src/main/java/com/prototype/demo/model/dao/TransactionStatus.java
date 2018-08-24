package com.prototype.demo.model.dao;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "transaction_status")
public class TransactionStatus {
    @Id
    @SequenceGenerator(name = "transaction_status_id_seq", sequenceName = "transaction_status_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_status_id_seq")
    @Column(name = "transaction_status_id")
    private Long transactionStatusId;

    @Column(name = "transaction_status_title")
    private String transactionStatusTitle;
}
