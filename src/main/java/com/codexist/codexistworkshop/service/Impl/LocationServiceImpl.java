package com.codexist.codexistworkshop.service.Impl;

import com.codexist.codexistworkshop.model.Location;
import com.codexist.codexistworkshop.service.LocationService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LocationServiceImpl implements LocationService {

    public String googleApiCall(Location location){

        //https://www.geeksforgeeks.org/how-to-call-or-consume-external-api-in-spring-boot/
        String uri = "https://maps.googleapis.com/maps/api/place/textsearch/" +
                "output_type?query=your_query&location=latitude,longitude";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return null;
    }
}
