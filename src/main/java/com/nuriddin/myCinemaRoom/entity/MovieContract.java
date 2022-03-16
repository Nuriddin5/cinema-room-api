package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 15.03.2022;

import com.nuriddin.myCinemaRoom.enums.MovieContractStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity


public class MovieContract extends AbsEntity {

    @ManyToOne
    Movie movie;

    @Column(nullable = false)
    Short numberOfSessions;

    @Column(nullable = false)
    Short distributor_share_in_percentage;

    @Column(nullable = false)
    Double minPricePerSeat;

    @Enumerated(EnumType.STRING)
    MovieContractStatus movieContractStatus;
}
