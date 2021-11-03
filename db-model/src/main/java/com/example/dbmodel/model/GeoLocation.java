package com.example.dbmodel.model;

import lombok.*;

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
