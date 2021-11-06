package com.example.application.service;


import com.example.application.dto.NearbyResponse;
import com.example.dbmodel.model.GeoLocation;
import com.example.dbmodel.model.NearbyPlaces;

public interface LocationService {

   public NearbyPlaces compareLocation(String location);

   public NearbyResponse googleApiCall(GeoLocation geoLocation)  ;
}
