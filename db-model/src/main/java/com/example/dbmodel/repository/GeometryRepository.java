package com.example.dbmodel.repository;

import com.example.dbmodel.model.Geometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeometryRepository extends JpaRepository<Geometry, Long> {

}
