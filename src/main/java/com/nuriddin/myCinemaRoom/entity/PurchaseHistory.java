package com.nuriddin.myCinemaRoom.entity;

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
public class PurchaseHistory extends AbsEntity {

    @OneToOne
    Ticket ticket;

    @ManyToOne
    PayType payType;

}
    