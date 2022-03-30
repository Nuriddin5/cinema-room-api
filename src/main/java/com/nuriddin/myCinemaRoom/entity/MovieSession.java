package com.nuriddin.myCinemaRoom.entity;


import com.nuriddin.myCinemaRoom.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class MovieSession extends AbsLongEntity {

    @ManyToOne()
    Theatre theatre;

    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Announcement announcement;

    @ManyToOne
    SessionDate session_date;

    @ManyToOne
    SessionTime start_time;

    @ManyToOne
    SessionTime end_time;

    @ManyToOne(optional = true)
    private Announcement announcements;

    public MovieSession(Theatre theatre, Announcement announcement, SessionDate session_date, SessionTime start_time, SessionTime end_time) {
        this.theatre = theatre;
        this.announcement = announcement;
        this.session_date = session_date;
        this.start_time = start_time;
        this.end_time = end_time;
    }
}

