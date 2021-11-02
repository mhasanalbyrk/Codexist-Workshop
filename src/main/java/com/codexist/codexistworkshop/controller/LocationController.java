package com.codexist.codexistworkshop.controller;

import com.codexist.codexistworkshop.model.GeoLocation;
import com.codexist.codexistworkshop.model.NearbyPlaces;
import com.codexist.codexistworkshop.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class LocationController {

    private LocationService locationService;


    @GetMapping("/location")
    public ResponseEntity<?> getLocation(@RequestBody GeoLocation geoLocation) throws JSONException {

        NearbyPlaces result = locationService.googleApiCall(geoLocation);
        return ResponseEntity.ok(result);
    }
}
