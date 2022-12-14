package com.nuriddin.myCinemaRoom.entity;

import com.nuriddin.myCinemaRoom.entity.template.AbsUUIDEntity;
import com.nuriddin.myCinemaRoom.enums.TicketStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Ticket extends AbsUUIDEntity {

    @ManyToOne()
    MovieSession movieSession;

    @OneToOne
    Seat seat;

//    @OneToOne
//    Attachment qrCode;

    @Column(nullable = false)
    Double price;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    TicketStatus status;

    @ManyToOne
    User user;
}
    