package com.codexist.codexistworkshop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class GeoLocation extends BaseEntity {



    private String location;
    private Long longitude;
    private Long altitude;
    private Long radius;
    private String response;


}
