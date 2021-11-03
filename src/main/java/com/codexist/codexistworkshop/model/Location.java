package com.codexist.codexistworkshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location extends BaseEntity{
    @JsonProperty("lat")
    private    Long     lat;
    @JsonProperty("lng")
    private    Long     lng;
}
