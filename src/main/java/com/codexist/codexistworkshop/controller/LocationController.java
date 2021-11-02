package com.codexist.codexistworkshop.controller;

import com.codexist.codexistworkshop.model.GeoLocation;
import com.codexist.codexistworkshop.model.NearbyPlaces;
import com.codexist.codexistworkshop.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/location")
    public ResponseEntity<?> getLocation(@RequestBody GeoLocation geoLocation) throws JSONException {

        NearbyPlaces result = locationService.googleApiCall(geoLocation);
        return ResponseEntity.ok(result);
    }
}
