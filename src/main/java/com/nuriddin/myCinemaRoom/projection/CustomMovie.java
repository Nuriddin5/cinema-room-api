package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.enums.AgeRate;
import com.nuriddin.myCinemaRoom.enums.Genre;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomMovie {
    Long getId();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();

    UUID getCreatedBy();

    UUID getUpdatedBy();

    String getName();

    String getTitle();

    String getDescription();

    AgeRate getAgeRate();

    Short getDuration();

    Short getYear();

    Genre getGenre();

    String getTrailerLink();

    AttachmentInfo getPosterImg();

    CityInfo getSelectedCityId();

    interface AttachmentInfo {
        Long getId();

        Timestamp getCreatedAt();

        Timestamp getUpdatedAt();

        UUID getCreatedBy();

        UUID getUpdatedBy();

        String getFileOriginalName();

        Long getSize();

        String getContentType();

        String getUniqueName();
    }

    interface CityInfo {
        Long getId();

        Timestamp getCreatedAt();

        Timestamp getUpdatedAt();

        UUID getCreatedBy();

        UUID getUpdatedBy();

        String getName();
    }
}
