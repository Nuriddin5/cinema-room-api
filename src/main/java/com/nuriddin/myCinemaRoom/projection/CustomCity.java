package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.City;
import org.springframework.data.rest.core.config.Projection;

import java.util.UUID;

@Projection(types = City.class)
public interface CustomCity {
    UUID getId();

    String getName();


}
