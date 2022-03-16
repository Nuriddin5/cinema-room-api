package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 15.03.2022;

import com.nuriddin.myCinemaRoom.entity.template.AbsEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class City extends AbsEntity {
    @Column(nullable = false)
    String name;
}
