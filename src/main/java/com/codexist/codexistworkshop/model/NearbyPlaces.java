package com.codexist.codexistworkshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NearbyPlaces extends BaseEntity{

    @Column(unique=true)
    private String location;
    @ManyToMany
    private List<Place> placeList;

}
