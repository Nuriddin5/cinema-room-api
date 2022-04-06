package com.nuriddin.myCinemaRoom.dto;


// t.me/superJavaDeveloper 30.03.2022;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity

public class TicketDto {
    UUID ticketId;
    Long sessionId;
    Long seatId;
//    Long userId;
}
