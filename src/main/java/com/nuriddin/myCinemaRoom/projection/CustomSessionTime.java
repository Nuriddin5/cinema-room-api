package com.nuriddin.myCinemaRoom.projection;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.UUID;

public interface CustomSessionTime {
    Long getId();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();

    UUID getCreatedBy();

    UUID getUpdatedBy();

    LocalTime getTime();
}
