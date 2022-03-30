package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 15.03.2022;

import com.nuriddin.myCinemaRoom.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class AddressInfo extends AbsLongEntity {
    String town;

    @Column(nullable = false)
    String streetAddress;

//    @ManyToOne(cascade = CascadeType.ALL)
//    City city;

    @OneToOne
//            (cascade = CascadeType.ALL)
    Location location;


}
