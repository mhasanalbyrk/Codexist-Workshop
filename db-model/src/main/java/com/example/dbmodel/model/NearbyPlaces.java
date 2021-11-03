package com.example.dbmodel.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
