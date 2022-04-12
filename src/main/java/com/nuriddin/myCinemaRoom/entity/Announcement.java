package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 15.03.2022;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nuriddin.myCinemaRoom.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Announcement extends AbsLongEntity {


    @ManyToOne()
//    @OnDelete(action = OnDeleteAction.CASCADE)
    MovieContract  movieContract;



    Boolean isActive;
    @JsonIgnore
    @OneToMany(mappedBy = "announcement",cascade = CascadeType.ALL)
    List<MovieSession> movieSessions;

    public Announcement(MovieContract  movieContract, Boolean isActive) {
        this. movieContract =  movieContract;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Announcement{" +
               " movieContract=" +  movieContract +
               ", isActive=" + isActive +
               '}';
    }
}

