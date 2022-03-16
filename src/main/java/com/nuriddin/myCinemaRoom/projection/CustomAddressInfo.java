package com.nuriddin.myCinemaRoom.projection;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomAddressInfo {
    UUID getId();


    String getTown();

    String getStreet_address();

    CityInfo getCity();

    LocationInfo getLocation();

    interface CityInfo {
        UUID getId();

        String getName();
    }

    interface LocationInfo {
        UUID getId();


        String getLongtitude();

        String getLattitude();
    }
}
