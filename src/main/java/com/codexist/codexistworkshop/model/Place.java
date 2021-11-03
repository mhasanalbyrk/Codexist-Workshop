package com.codexist.codexistworkshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Place extends BaseEntity{

    @JsonProperty("name")
    private String name;
    @JsonProperty("types")
    @ElementCollection
    List<String> types;
    @JsonProperty("geometry")
    @OneToOne
    private Geometry geometry;
}
