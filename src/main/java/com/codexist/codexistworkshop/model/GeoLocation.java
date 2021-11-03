package com.codexist.codexistworkshop.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeoLocation extends BaseEntity {


    private Long longitude;
    private Long altitude;
    private Long radius;


}
