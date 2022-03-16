package com.nuriddin.myCinemaRoom.entity;


import com.nuriddin.myCinemaRoom.entity.template.AbsEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class MovieSession extends AbsEntity {

    @ManyToOne
    Movie movie;

    @ManyToOne
    Theatre theatre;

}

