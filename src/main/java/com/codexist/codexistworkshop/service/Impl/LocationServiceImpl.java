package com.codexist.codexistworkshop.service.Impl;

import com.codexist.codexistworkshop.dto.NearbyResponse;
import com.codexist.codexistworkshop.service.LocationService;
import com.example.dbmodel.model.GeoLocation;
import com.example.dbmodel.model.NearbyPlaces;
import com.example.dbmodel.repository.NearbyPlacesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final NearbyPlacesRepository nearbyPlacesRepository;
    @Qualifier("googleRestTemplate")
    private final RestTemplate newRestTemplate;

    @Override
    public NearbyPlaces compareLocation(GeoLocation geoLocation) {


//        if (locationRepository.existsByLocation(
//                geoLocation.getAltitude().toString()
//                        + geoLocation.getLongitude().toString()
//                        + geoLocation.getRadius().toString())) {
//
//            return null;
//        }
//
//        return null;

        return null;
    }

    public NearbyPlaces googleApiCall(GeoLocation geoLocation) throws JSONException {

        NearbyPlaces comparedLocation = compareLocation(geoLocation);
        if (comparedLocation == null) {
            //"https://maps.googleapis.com/maps/api/place/textsearch/
            // json?query=coffee+shop&
            // location=35.792491,
            // -78.653009&
            // radius=2000&
            // region=us&type=cafe,bakery&
            // key=MY_API_KEY"
            String MY_API_KEY = "";
            //https://www.geeksforgeeks.org/how-to-call-or-consume-external-api-in-spring-boot/
            String uri = "https://maps.googleapis.com/maps/api/place/nearbysearch/" +
                    "json?location=" +
                    geoLocation.getAltitude() +
                    "," +
                    geoLocation.getLongitude() +
                    "&radius=" +
                    geoLocation.getRadius() +
                    "&key=" + MY_API_KEY;
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<NearbyResponse> result = restTemplate.getForEntity(uri, NearbyResponse.class);


            return null;
        } else {
            return null;
        }
    }
}
