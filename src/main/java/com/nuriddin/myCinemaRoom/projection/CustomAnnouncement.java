package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.Movie;
import com.nuriddin.myCinemaRoom.enums.MovieContractStatus;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomAnnouncement {
    Long getId();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();

    UUID getCreatedBy();

    UUID getUpdatedBy();

    Boolean isIsActive();

    MovieContractInfo getMovie_contract();

    interface MovieContractInfo {
        Long getId();

        Timestamp getCreatedAt();

        Timestamp getUpdatedAt();

        UUID getCreatedBy();

        UUID getUpdatedBy();

        Movie getMovie();

        Short getNumberOfSessions();

        Short getDistributor_share_in_percentage();

        Double getMinPricePerSeat();

        MovieContractStatus getMovieContractStatus();
    }
}
