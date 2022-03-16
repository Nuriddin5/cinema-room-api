package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 15.03.2022;

import com.nuriddin.myCinemaRoom.entity.template.AbsEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Row extends AbsEntity {
    @Column(nullable = false)
    Integer number;

    @ManyToOne
    Theatre theatre;

}
