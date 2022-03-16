package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.Movie;
import com.nuriddin.myCinemaRoom.enums.MovieContractStatus;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomAnnouncement {
    UUID getId();



    Boolean isIsActive();

    MovieContractInfo getMovie_contract();

    interface MovieContractInfo {
        UUID getId();


        Movie getMovie();

        Short getNumberOfSessions();

        Short getDistributor_share_in_percentage();

        Double getMinPricePerSeat();

        MovieContractStatus getMovieContractStatus();
    }
}
