package com.codexist.codexistworkshop.dto;

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
    private String name;
    private List<String> types;
}
