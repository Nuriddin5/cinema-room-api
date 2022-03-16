package com.nuriddin.myCinemaRoom.projection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nuriddin.myCinemaRoom.enums.AgeRate;
import com.nuriddin.myCinemaRoom.enums.Genre;

import java.util.UUID;

public interface CustomMovie {

    String getId();


    String getName();

    String getTitle();

    String getDescription();

    @JsonIgnore
    AgeRate getAgeRate();

    @JsonIgnore
    Short getDuration();

    @JsonIgnore
    Short getYear();

    Genre getGenre();

    String getTrailerLink();

    AttachmentInfo getPosterImg();

    CityInfo getSelectedCityId();

    interface AttachmentInfo {
        UUID getId();

        String getFileName();

        String getContentType();

        Long getSize();
    }

    interface CityInfo {
        UUID getId();

        String getName();
    }
}
