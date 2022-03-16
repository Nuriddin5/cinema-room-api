package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.AddressInfo;
import com.nuriddin.myCinemaRoom.entity.City;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomRow {
    UUID getId();


    Integer getNumber();

    TheatreInfo getTheatre();

    interface TheatreInfo {
        UUID getId();

        Timestamp getCreatedAt();

        Timestamp getUpdatedAt();

        UUID getCreatedBy();

        UUID getUpdatedBy();

        String getName();

        String getTelephone_number();

        City getCity();

        AddressInfo getAddress_info();
    }
}
