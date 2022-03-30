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
    MovieContract movie_contract;



    Boolean isActive;
    @JsonIgnore
    @OneToMany(mappedBy = "announcements",cascade = CascadeType.ALL)
    List<MovieSession> movieSessions;

    public Announcement(MovieContract movie_contract, Boolean isActive) {
        this.movie_contract = movie_contract;
        this.isActive = isActive;
    }
}

