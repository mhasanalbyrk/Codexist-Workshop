package com.example.application.service.Impl;

import com.example.application.dto.NearbyResponse;
import com.example.application.dto.PlaceDTO;
import com.example.application.maps.PlaceMapper;
import com.example.application.service.CoordinateService;
import com.example.application.service.GeometryService;
import com.example.application.service.LocationService;
import com.example.application.service.PlaceService;
import com.example.dbmodel.model.GeoLocation;
import com.example.dbmodel.model.NearbyPlaces;
import com.example.dbmodel.model.Place;
import com.example.dbmodel.repository.NearbyPlacesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {


    private final CoordinateService coordinateService;
    private final GeometryService geometryService;
    private final PlaceService placeService;
    private final PlaceMapper placeMapper;

   private final NearbyPlacesRepository nearbyPlacesRepository;

    @Qualifier("googleRestTemplate")
    private final RestTemplate newRestTemplate;

    @Override
    public NearbyPlaces compareLocation(String location) {



        if (nearbyPlacesRepository.existsByLocation(location) ){

            return nearbyPlacesRepository.findByLocation(location);
        }

        return null;
    }

    public NearbyResponse googleApiCall(GeoLocation geoLocation)   {

        String location = geoLocation.getAltitude().toString()
                + geoLocation.getLongitude().toString()
                + geoLocation.getRadius().toString();
        NearbyPlaces comparedLocation = compareLocation(location);
        if (comparedLocation == null) {
            //"https://maps.googleapis.com/maps/api/place/textsearch/
            // json?query=coffee+shop&
            // location=35.792491,
            // -78.653009&
            // radius=2000&
            // region=us&type=cafe,bakery&
            // key=MY_API_KEY"
            String MY_API_KEY = "AIzaSyAvGImrhmGQjB__qjPahoRBlBnC9VThGH4";
            //https://www.geeksforgeeks.org/how-to-call-or-consume-external-api-in-spring-boot/
            String uri = "https://maps.googleapis.com/maps/api/place/nearbysearch/" +
                    "json?location=" +
                    geoLocation.getAltitude() +
                    "," +
                    geoLocation.getLongitude() +
                    "&radius=" +
                    geoLocation.getRadius() +
                    "&key=" + MY_API_KEY;

            // RestTemplate restTemplate = new RestTemplate();

           ResponseEntity<NearbyResponse> result = newRestTemplate.getForEntity(uri, NearbyResponse.class);


            List<Place> placeList = new ArrayList<Place>();
            for (PlaceDTO placeDTO: Objects.requireNonNull(result.getBody()).getResult()) {
                placeList.add(placeMapper.placeDTOtoPlace(placeDTO));
            }

           NearbyPlaces nearbyPlaces = NearbyPlaces.builder().placeList(placeList).location(location).build();

            for (Place place: placeList) {
                coordinateService.create(place.getGeometry().getLocation());
                geometryService.create(place.getGeometry());
            }
            placeService.createAll(placeList);
            nearbyPlacesRepository.save(nearbyPlaces);
            return NearbyResponse.builder().result(result.getBody().getResult()).build();
        } else {
            List<PlaceDTO> placeDTOList = new ArrayList<PlaceDTO>();
            for (Place place: comparedLocation.getPlaceList()) {
                placeDTOList.add(placeMapper.placeToPlaceDTO(place));
            }

            return NearbyResponse.builder().result(placeDTOList).build();
        }
    }
}
