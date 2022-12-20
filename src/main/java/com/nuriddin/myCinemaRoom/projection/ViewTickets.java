package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.enums.TicketStatus;

import java.util.UUID;

public interface ViewTickets {
    UUID getId();

    Double getPrice();

    TicketStatus getStatus();


    SeatInfo getSeat();

    UserInfo getUser();



    interface SeatInfo {
        Integer getNumber();
    }

    interface UserInfo {
        String getFirstName();

        String getLastName();

        String getUsername();
    }
}
