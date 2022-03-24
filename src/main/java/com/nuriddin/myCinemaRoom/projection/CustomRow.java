package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.AddressInfo;
import com.nuriddin.myCinemaRoom.entity.City;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomRow {
    Long getId();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();

    UUID getCreatedBy();

    UUID getUpdatedBy();

    Integer getNumber();

    TheatreInfo getTheatre();

    interface TheatreInfo {
        Long getId();

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
