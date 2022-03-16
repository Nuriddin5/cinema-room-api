package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.City;
import com.nuriddin.myCinemaRoom.entity.Location;

import java.util.UUID;

public interface CustomTheatre {
    UUID getId();

    String getName();

    String getTelephone_number();

    CityInfo getCity();

    Address_InfoInfo getAddress_info();

    interface CityInfo {
        String getName();
    }

    interface Address_InfoInfo {
        String getTown();

        String getStreet_address();

        City getCity();

        Location getLocation();
    }
}
