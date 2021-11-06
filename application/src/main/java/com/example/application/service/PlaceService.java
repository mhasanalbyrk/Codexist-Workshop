package com.example.application.service;

import com.example.dbmodel.model.Place;

import java.util.List;

public interface PlaceService {
    Place create(Place place);
    List<Place> createAll(List<Place> places);
}
