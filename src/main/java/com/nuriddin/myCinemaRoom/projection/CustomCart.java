package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.*;
import com.nuriddin.myCinemaRoom.enums.TicketStatus;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface CustomCart {
    UUID getId();


    UserInfo getUser();

    List<TicketInfo> getTickets();

    interface UserInfo {
        UUID getId();


        String getFirstName();

        String getLastName();

        String getUsername();

        String getPhoneNumber();

        String getPassword();

        City getSelectedCityId();
    }

    interface TicketInfo {
        UUID getId();

        MovieSession getMovieSession();

        Seat getSeat();

        Attachment getQrCode();

        Double getPrice();

        TicketStatus getStatus();

        Cart getCart();
    }
}
