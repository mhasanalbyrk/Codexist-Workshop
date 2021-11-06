package com.example.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LocationDTO {
    @JsonProperty("lat")
    private    Long     lat;
    @JsonProperty("lng")
    private    Long     lng;
}
