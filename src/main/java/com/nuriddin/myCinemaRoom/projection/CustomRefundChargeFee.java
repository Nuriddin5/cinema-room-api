package com.nuriddin.myCinemaRoom.projection;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomRefundChargeFee {
    UUID getId();

    Integer getIntervalInMin();

    Double getFeeInPercentage();
}
