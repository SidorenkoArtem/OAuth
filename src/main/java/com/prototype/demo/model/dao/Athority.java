package com.prototype.demo.model.dao;

import lombok.Data;

import javax.persistence.*;

/**
 * DAO model for Authority entity
 */
@Entity
@Data
public class Athority {
    /**
     * Identifier for authority.
     */
    @Id
    @SequenceGenerator(name = "authority_id_seq", sequenceName = "authority_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_id_seq")
    private Long id;

    /**
     * Name authority field.
     */
    private String name;
}
