package com.codexist.codexistworkshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PlaceDTO {
    @Id
    private Long id;
    @JsonProperty("name")
    private String name;
    private List<String> types;
}
