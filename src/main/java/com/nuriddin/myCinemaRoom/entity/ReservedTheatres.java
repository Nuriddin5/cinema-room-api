package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 15.03.2022;

import com.nuriddin.myCinemaRoom.entity.template.AbsLongEntity;
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

public class ReservedTheatres extends AbsLongEntity {

    @ManyToOne
    Theatre theatre;

    @ManyToOne
    Announcement announcement;

    @ManyToOne
    SessionDate session_date;

    @ManyToOne
    SessionTime start_time;

    @ManyToOne
    SessionTime end_time;


}
