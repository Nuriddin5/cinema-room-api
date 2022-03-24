package com.nuriddin.myCinemaRoom.projection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomCity {
    Long getId();

//    @JsonIgnore
    Timestamp getCreatedAt();

//    @JsonIgnore
    Timestamp getUpdatedAt();

    @JsonIgnore
    UUID getCreatedBy();

    @JsonIgnore
    UUID getUpdatedBy();

    String getName();
}
