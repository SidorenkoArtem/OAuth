package com.prototype.demo.model.dao;

import lombok.Data;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Primary key for table user authority.
 */
@Data
@Embeddable
public class UserAuthorityId implements Serializable {
    private Long authorityId;
    private Long userId;
}
