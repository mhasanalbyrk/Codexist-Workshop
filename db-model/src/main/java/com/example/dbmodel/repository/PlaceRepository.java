package com.example.dbmodel.repository;

import com.example.dbmodel.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
