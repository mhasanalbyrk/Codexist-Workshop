package com.codexist.codexistworkshop.service.Impl;

import com.codexist.codexistworkshop.model.Location;
import com.codexist.codexistworkshop.repository.LocationRepository;
import com.codexist.codexistworkshop.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    public boolean compareLocation(Location location) {
        List<Location> locationList = locationRepository.findAll();
        for (Location location1 : locationList) {
            if (location1.getAltitude() == location.getAltitude() &&
                    location1.getLongitude() == location.getLongitude() &&
                    location1.getRadius() == location.getRadius()){
                return true;
            }
        }
        return false;
    }

    public String googleApiCall(Location location){

        String MY_API_KEY = "key";
        //https://www.geeksforgeeks.org/how-to-call-or-consume-external-api-in-spring-boot/
        String uri = "https://maps.googleapis.com/maps/api/place/textsearch/" +
                "output_type?query=your_query&location=latitude,longitude&key=" + MY_API_KEY;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }
}
