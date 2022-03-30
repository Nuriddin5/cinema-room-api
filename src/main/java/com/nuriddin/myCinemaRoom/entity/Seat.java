package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 15.03.2022;

import com.nuriddin.myCinemaRoom.entity.template.AbsLongEntity;
import com.nuriddin.myCinemaRoom.enums.Type;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
//@Transactional


public class Seat extends AbsLongEntity {
    @Column(nullable = false)
    Integer number;

//    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    Type type;

    @ManyToOne(optional = false)
    Row row;

    public Seat(Integer number, Row row) {
        this.number = number;
        this.row = row;
    }
}
