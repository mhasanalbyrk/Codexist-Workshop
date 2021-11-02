package com.codexist.codexistworkshop.service;

import com.codexist.codexistworkshop.model.GeoLocation;
import com.codexist.codexistworkshop.model.NearbyPlaces;
import org.springframework.boot.configurationprocessor.json.JSONException;

public interface LocationService {

   public NearbyPlaces compareLocation(GeoLocation geoLocation);

   public NearbyPlaces googleApiCall(GeoLocation geoLocation) throws JSONException;
}
