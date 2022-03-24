package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.*;
import com.nuriddin.myCinemaRoom.enums.TicketStatus;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public interface CustomCart {

    Long getId();

    Timestamp getUpdatedAt();

    UUID getCreatedBy();

    UUID getUpdatedBy();

    UserInfo getUser();

    List<TicketInfo> getTickets();

    interface UserInfo {
        UUID getId();

        Timestamp getCreatedAt();

        Timestamp getUpdatedAt();

        UUID getCreatedBy();

        UUID getUpdatedBy();

        String getFirstName();

        String getLastName();

        String getUsername();

        String getPhoneNumber();

        String getPassword();

        City getSelectedCityId();
    }

    interface TicketInfo {
        UUID getId();

        Timestamp getCreatedAt();

        Timestamp getUpdatedAt();

        UUID getCreatedBy();

        UUID getUpdatedBy();

        MovieSession getMovieSession();

        Seat getSeat();

        Attachment getQrCode();

        Double getPrice();

        TicketStatus getStatus();

        Cart getCart();
    }
}
