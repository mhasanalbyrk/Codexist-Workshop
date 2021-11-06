package com.example.dbmodel.repository;


import com.example.dbmodel.model.NearbyPlaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NearbyPlacesRepository extends JpaRepository<NearbyPlaces, Long> {

    boolean existsByLocation(String location);
    NearbyPlaces findByLocation(String location);
}
