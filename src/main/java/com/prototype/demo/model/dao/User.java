package com.prototype.demo.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * DAO model for users entity.
 */
@Data
@Entity
@Table(name = "users")
public class User {
    /**
     * User identifier field.
     */
    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private Long id;

    /**
     * User name field.
     */
    @JsonIgnore
    private String username;

    /**
     * Phone number field.
     */
    private String phone;

    /**
     * Password field.
     */
    private String password;

    /**
     * Date creating user record field.
     */
    @Column(name = "date_created")
    private LocalDateTime dateCreated;
}
