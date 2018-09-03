package com.prototype.demo.model.dao;

import lombok.Data;

import javax.persistence.*;

/**
 * DAO model for user authorities
 */
@Data
@Entity
@Table(name = "users_authorities")
@IdClass(UserAuthorityId.class)
public class UserAuthorities {

    /**
     * Authority identifier field.
     */
    @Id
    @Column(name = "authority_id")
    private Long authorityId;

    /**
     * User identifier field.
     */
    @Id
    @Column(name = "user_id")
    private Long userId;
}
