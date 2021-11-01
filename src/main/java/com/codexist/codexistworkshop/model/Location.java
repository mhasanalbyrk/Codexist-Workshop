package com.codexist.codexistworkshop.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Location extends BaseEntity {

    private Long longitude;
    private Long altitude;
    private Long radius;

}
