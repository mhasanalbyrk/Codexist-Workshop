package com.codexist.codexistworkshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class LocationController {

    @GetMapping("/location")
    public ResponseEntity<?> getLocation(){

        return null;
    }
}
