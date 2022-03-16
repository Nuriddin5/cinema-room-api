package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 15.03.2022;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class ReservedTheatres extends AbsEntity {

    @ManyToOne
    Theatre theatre;

    @ManyToOne
    Announcement announcement;

    @ManyToOne
    Session_date session_date;

    @ManyToOne
    Session_time start_time;

    @ManyToOne
    Session_time end_time;


}
