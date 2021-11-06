package com.example.application.controller;

import com.example.application.dto.NearbyResponse;
import com.example.application.service.LocationService;
import com.example.dbmodel.model.GeoLocation;
import com.example.dbmodel.model.NearbyPlaces;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class LocationController {
    private final LocationService locationService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/location")
    public ResponseEntity<?> getLocation(@RequestBody GeoLocation geoLocation)  {

        NearbyResponse result = locationService.googleApiCall(geoLocation);
        return ResponseEntity.ok(result);
    }
}
