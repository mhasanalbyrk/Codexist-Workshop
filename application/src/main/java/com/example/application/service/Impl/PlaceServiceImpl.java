package com.example.application.service.Impl;

import com.example.application.service.PlaceService;
import com.example.dbmodel.model.Place;
import com.example.dbmodel.repository.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlaceServiceImpl implements PlaceService {
    @Override
    public List<Place> createAll(List<Place> places) {
        return placeRepository.saveAllAndFlush(places);
    }

    private final PlaceRepository placeRepository;
    @Override
    public Place create(Place place) {
        return placeRepository.save(place);
    }
}
