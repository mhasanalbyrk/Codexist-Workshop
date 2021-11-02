package com.codexist.codexistworkshop.dto;

import com.codexist.codexistworkshop.model.Place;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestResponse {

    @JsonProperty("results")
    private List<Place> result;

}
