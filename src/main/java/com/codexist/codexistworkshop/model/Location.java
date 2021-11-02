package com.codexist.codexistworkshop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.persistence.*;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Location extends BaseEntity {



    private String location;
    private Long longitude;
    private Long altitude;
    private Long radius;
    @Column(columnDefinition = "LONGTEXT")
    private String response;


}
