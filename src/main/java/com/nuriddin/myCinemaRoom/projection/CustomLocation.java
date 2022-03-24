package com.nuriddin.myCinemaRoom.projection;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomLocation {
    Long getId();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();

    UUID getCreatedBy();

    UUID getUpdatedBy();

    String getLongtitude();

    String getLattitude();
}
