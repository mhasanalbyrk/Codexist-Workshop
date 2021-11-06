package com.example.application.service.Impl;

import com.example.application.service.GeometryService;
import com.example.dbmodel.model.Geometry;
import com.example.dbmodel.repository.GeometryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GeometryServiceImpl implements GeometryService {
    private final GeometryRepository geometryRepository;
    @Override
    public Geometry create(Geometry geometry) {
        return geometryRepository.save(geometry);
    }
}
