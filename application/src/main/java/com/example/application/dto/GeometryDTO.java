package com.example.application.dto;

import com.example.dbmodel.model.Location;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.OneToOne;

public class GeometryDTO {
    @JsonProperty("location")
    @OneToOne
    private Location location;
}
