package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.Theatre;
import com.nuriddin.myCinemaRoom.enums.Type;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomSeat {
    Long getId();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();

    UUID getCreatedBy();

    UUID getUpdatedBy();

    Integer getNumber();

    Type getType();

    RowInfo getRow();

    interface RowInfo {
        Long getId();

        Timestamp getCreatedAt();

        Timestamp getUpdatedAt();

        UUID getCreatedBy();

        UUID getUpdatedBy();

        Integer getNumber();

        Theatre getTheatre();
    }
}
