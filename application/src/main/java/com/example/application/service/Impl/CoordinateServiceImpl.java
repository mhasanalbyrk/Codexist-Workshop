package com.example.application.service.Impl;

import com.example.application.service.CoordinateService;
import com.example.dbmodel.model.Location;
import com.example.dbmodel.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CoordinateServiceImpl implements CoordinateService {

    private final LocationRepository locationRepository;

    @Override
    public Location create(Location location) {
        return locationRepository.save(location);
    }
}
