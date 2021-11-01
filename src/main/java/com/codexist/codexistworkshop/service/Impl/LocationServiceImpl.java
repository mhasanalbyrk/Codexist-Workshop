package com.codexist.codexistworkshop.service.Impl;

import com.codexist.codexistworkshop.model.Location;
import com.codexist.codexistworkshop.repository.LocationRepository;
import com.codexist.codexistworkshop.service.LocationService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location createLocation(Location location){

        return locationRepository.save(location);
    }

    @Override
    public String compareLocation(Location location) {
        
        List<Location> locationList = locationRepository.findAll();
        for (Location location1 : locationList) {
            if (Objects.equals(location1.getAltitude(), location.getAltitude()) &&
                    Objects.equals(location1.getLongitude(), location.getLongitude()) &&
                    Objects.equals(location1.getRadius(), location.getRadius())){
                return location1.getResponse();
            }
        }
        return "New";
    }

    public JSONObject googleApiCall(Location location) throws JSONException {


        String comparedLocation = compareLocation(location);
        if ("New".equals(comparedLocation)) {


            //"https://maps.googleapis.com/maps/api/place/textsearch/
            // json?query=coffee+shop&
            // location=35.792491,
            // -78.653009&
            // radius=2000&
            // region=us&type=cafe,bakery&
            // key=MY_API_KEY"
            String MY_API_KEY = "key";
            //https://www.geeksforgeeks.org/how-to-call-or-consume-external-api-in-spring-boot/
            String uri = "https://maps.googleapis.com/maps/api/place/nearbysearch/" +
                    "json?location=" +
                    location.getAltitude() +
                    "," +
                    location.getLongitude() +
                    "&radius=" +
                    location.getRadius() +
                    "&key=" + MY_API_KEY;
            RestTemplate restTemplate = new RestTemplate();
            Gson gson = new Gson();

            String result = restTemplate.getForObject(uri, String.class);
          // result = gson.toJson(result);
            JSONObject jsonObject= new JSONObject(result);
            location.setResponse(result);

            createLocation(location);
            return jsonObject;
        }
        else {
            return  new JSONObject(comparedLocation);
        }
    }
}
