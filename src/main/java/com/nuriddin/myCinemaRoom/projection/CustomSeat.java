package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.enums.Type;

import java.util.UUID;

public interface CustomSeat {
    UUID getId();

    Integer getNumber();

    Type getType();
}
