package com.nuriddin.myCinemaRoom.projection;

import java.time.LocalTime;
import java.util.UUID;

public interface CustomSessionTime {
    UUID getId();

    LocalTime getTime();
}
