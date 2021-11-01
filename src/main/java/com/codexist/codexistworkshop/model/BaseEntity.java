package com.codexist.codexistworkshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuperBuilder
@Data
@NoArgsConstructor
public class BaseEntity {
    private Long id;

    protected void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

}
