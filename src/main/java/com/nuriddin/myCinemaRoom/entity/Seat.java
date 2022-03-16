package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 15.03.2022;

import com.nuriddin.myCinemaRoom.entity.template.AbsEntity;
import com.nuriddin.myCinemaRoom.enums.Type;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Seat extends AbsEntity {
    @Column(nullable = false)
    Integer number;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Type type;

    @ManyToOne
    Row row;

}
