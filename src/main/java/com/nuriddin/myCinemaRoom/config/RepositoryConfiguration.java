package com.nuriddin.myCinemaRoom.config;


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

import com.nuriddin.myCinemaRoom.handler.city.CityEventHandler;
import com.nuriddin.myCinemaRoom.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Autowired
    CityRepository cityRepository;

    @Bean
    CityEventHandler personEventHandler() {
        return new CityEventHandler(cityRepository);
    }
}

