package com.nuriddin.myCinemaRoom.projection;

import java.time.LocalDate;
import java.util.UUID;

public interface CustomSessionDate {
    UUID getId();

    LocalDate getDate();
}
