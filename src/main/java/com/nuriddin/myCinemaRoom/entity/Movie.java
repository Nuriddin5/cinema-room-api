package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 15.03.2022;

import com.nuriddin.myCinemaRoom.entity.template.AbsLongEntity;
import com.nuriddin.myCinemaRoom.enums.AgeRate;
import com.nuriddin.myCinemaRoom.enums.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity


public class Movie extends AbsLongEntity {
    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String title;

    @Column(columnDefinition = "text")
    String description;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    AgeRate ageRate;

    @Column(nullable = false)
    Short duration;

    //    @Column(nullable = false)
    Short year;

        @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    Genre genre;

    @OneToOne
    Attachment posterImg;

    String trailerLink;

    @ManyToOne
    City selectedCityId;


}
