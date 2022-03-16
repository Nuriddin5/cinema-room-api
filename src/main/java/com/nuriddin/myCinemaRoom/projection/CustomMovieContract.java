package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.Attachment;
import com.nuriddin.myCinemaRoom.entity.City;
import com.nuriddin.myCinemaRoom.enums.AgeRate;
import com.nuriddin.myCinemaRoom.enums.Genre;
import com.nuriddin.myCinemaRoom.enums.MovieContractStatus;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomMovieContract {
    UUID getId();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();

    UUID getCreatedBy();

    UUID getUpdatedBy();

    Short getNumberOfSessions();

    Short getDistributor_share_in_percentage();

    Double getMinPricePerSeat();

    MovieContractStatus getMovieContractStatus();

    MovieInfo getMovie();

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
}
