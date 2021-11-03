package com.codexist.codexistworkshop.repository;

import com.codexist.codexistworkshop.model.GeoLocation;
import com.codexist.codexistworkshop.model.Location;
import com.codexist.codexistworkshop.model.NearbyPlaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    //boolean existsByLocation(String location);
}
