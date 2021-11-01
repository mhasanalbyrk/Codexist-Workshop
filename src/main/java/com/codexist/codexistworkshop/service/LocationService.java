package com.codexist.codexistworkshop.service;

import com.codexist.codexistworkshop.model.Location;

import java.util.List;

public interface LocationService {

   public boolean compareLocation(Location location);

   public String googleApiCall(Location location);
}
