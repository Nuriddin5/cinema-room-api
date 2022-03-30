package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.Seat;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Seat.class)
public interface AvailableSeat {
    Long getId();

    Integer getSeatNumber();

    Integer getRowNumber();

    boolean isAvailable();


}
