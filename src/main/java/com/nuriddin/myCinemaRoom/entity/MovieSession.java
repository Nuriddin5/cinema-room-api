package com.nuriddin.myCinemaRoom.entity;


import com.nuriddin.myCinemaRoom.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class MovieSession extends AbsLongEntity {

    @ManyToOne()
    Theatre theatre;


    @ManyToOne
    SessionDate sessionDate;

    @ManyToOne
    SessionTime startTime;

    @ManyToOne
    SessionTime endTime;

    @ManyToOne()
    private Announcement announcement;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MovieSession that = (MovieSession) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

