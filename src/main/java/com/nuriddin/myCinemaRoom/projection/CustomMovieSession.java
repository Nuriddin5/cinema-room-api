package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.AddressInfo;
import com.nuriddin.myCinemaRoom.entity.Attachment;
import com.nuriddin.myCinemaRoom.entity.City;
import com.nuriddin.myCinemaRoom.enums.AgeRate;
import com.nuriddin.myCinemaRoom.enums.Genre;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomMovieSession {
    UUID getId();


    MovieInfo getMovie();

    TheatreInfo getTheatre();

    interface MovieInfo {
        UUID getId();

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

        Attachment getPosterImg();

        String getTrailerLink();

        City getSelectedCityId();
    }

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
