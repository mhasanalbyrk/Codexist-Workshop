package com.codexist.codexistworkshop.dto;


import com.example.dbmodel.model.Geometry;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PlaceDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("types")
    List<String> types;
    @JsonProperty("geometry")
    private Geometry geometry;
}