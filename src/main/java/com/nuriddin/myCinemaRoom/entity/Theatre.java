package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 15.03.2022;

import com.nuriddin.myCinemaRoom.entity.template.AbsEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Theatre extends AbsEntity {
    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String telephone_number;

    @ManyToOne
    City city;

    @OneToOne
    AddressInfo address_info;




}
