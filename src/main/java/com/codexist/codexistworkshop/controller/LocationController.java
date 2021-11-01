package com.codexist.codexistworkshop.controller;

import com.codexist.codexistworkshop.model.Location;
import com.codexist.codexistworkshop.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<?> getLocation(@RequestBody Location location){

        String result = locationService.googleApiCall(location);
        return ResponseEntity.ok(result);
    }
}
