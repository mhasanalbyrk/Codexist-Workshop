package com.codexist.codexistworkshop.service;

import com.codexist.codexistworkshop.model.Location;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.List;

public interface LocationService {

   public String compareLocation(Location location);

   public JSONObject googleApiCall(Location location) throws JSONException;
}
