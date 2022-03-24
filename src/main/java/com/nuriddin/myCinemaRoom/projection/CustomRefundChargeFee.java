package com.nuriddin.myCinemaRoom.projection;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomRefundChargeFee {
    Long getId();

    Timestamp getCreatedAt();

    Timestamp getUpdatedAt();

    UUID getCreatedBy();

    UUID getUpdatedBy();

    Integer getIntervalInMin();

    Double getFeeInPercentage();
}
