package com.prototype.demo.model.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users_authorities")
@IdClass(UserAuthorityId.class)
public class UserAuthorities {

    @Id
    @Column(name = "authority_id")
    private Long authorityId;

    @Id
    @Column(name = "user_id")
    private Long userId;
}
