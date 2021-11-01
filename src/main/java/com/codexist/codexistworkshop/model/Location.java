package com.codexist.codexistworkshop.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import javax.persistence.*;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Location  {

    private Long longitude;
    private Long altitude;
    private Long radius;
    @Column(columnDefinition = "LONGTEXT")
    private String response;
    //private JSONObject kk;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
