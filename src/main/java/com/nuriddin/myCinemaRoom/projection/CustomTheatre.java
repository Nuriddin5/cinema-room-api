package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.City;
import com.nuriddin.myCinemaRoom.entity.Location;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomTheatre {
    Long getId();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();

    UUID getCreatedBy();

    UUID getUpdatedBy();

    String getName();

    String getTelephone_number();

    CityInfo getCity();

    AddressInfoInfo getAddress_info();

    interface CityInfo {
        Long getId();

        Timestamp getCreatedAt();

        Timestamp getUpdatedAt();

        UUID getCreatedBy();

        UUID getUpdatedBy();

        String getName();
    }

    interface AddressInfoInfo {
        Long getId();

        Timestamp getCreatedAt();

        Timestamp getUpdatedAt();

        UUID getCreatedBy();

        UUID getUpdatedBy();

        String getTown();

        String getStreet_address();

        City getCity();

        Location getLocation();
    }
}
