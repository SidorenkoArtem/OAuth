package com.prototype.demo.model.dao;

import lombok.Data;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class UserAuthorityId implements Serializable {
    private Long authorityId;
    private Long userId;
}
