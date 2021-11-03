package com.codexist.codexistworkshop.maps;

import com.codexist.codexistworkshop.dto.PlaceDTO;
import com.example.dbmodel.model.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper( componentModel = "spring")
public interface PlaceMapper {

    PlaceMapper INSTANCE = Mappers.getMapper(PlaceMapper.class);

   // @Mapping(source = "place.name", target = "name", defaultValue = "name")
    PlaceDTO placeToPlaceDTO(Place place);
    Place placeDTOtoPlace(PlaceDTO placeDTO);
}
