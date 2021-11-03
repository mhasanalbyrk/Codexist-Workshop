package com.codexist.codexistworkshop.service;


import com.example.dbmodel.model.GeoLocation;
import com.example.dbmodel.model.NearbyPlaces;
import org.springframework.boot.configurationprocessor.json.JSONException;

public interface LocationService {

   public NearbyPlaces compareLocation(GeoLocation geoLocation);

   public NearbyPlaces googleApiCall(GeoLocation geoLocation) throws JSONException;
}
