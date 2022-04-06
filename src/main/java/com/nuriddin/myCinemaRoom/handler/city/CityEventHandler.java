package com.nuriddin.myCinemaRoom.handler.city;


// t.me/superJavaDeveloper 05.04.2022;

//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.Entity;
//import java.util.UUID;
//
//@EqualsAndHashCode(callSuper = true)
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity

import com.nuriddin.myCinemaRoom.entity.City;
import com.nuriddin.myCinemaRoom.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

@RepositoryEventHandler
@RequiredArgsConstructor
public class CityEventHandler {

    private final CityRepository cityRepository;

    @HandleBeforeCreate
    public HttpEntity<?> handleCitySave(City city) {
        try {
            if (cityRepository.existsByName(city.getName())) {
                return ResponseEntity.status(409).body("unique");
            }
        } catch (Exception e) {

            return ResponseEntity.status(200).body("City successfully added");
        }
        return null;
    }
}

//    @HandleBeforeSave
//    public void handleProfileSave(Profile p) {
//        // … you can now deal with Profile in a type-safe way
//    }
//}

