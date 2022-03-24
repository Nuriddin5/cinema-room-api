package com.nuriddin.myCinemaRoom.projection;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

public interface CustomSessionDate {
    Long getId();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();

    UUID getCreatedBy();

    UUID getUpdatedBy();

    LocalDate getDate();
}
