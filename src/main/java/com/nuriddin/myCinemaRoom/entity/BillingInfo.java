package com.nuriddin.myCinemaRoom.entity;


import com.nuriddin.myCinemaRoom.entity.template.AbsEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class BillingInfo extends AbsEntity {

    @ManyToOne
    User user;

    @Column(nullable = false)
    String cardHolderName;

    @Column(nullable = false, unique = true)
    String cardNumber;

    @Column(nullable = false)
    LocalDate expirationDate;

    @Column(nullable = false)
    Short cvc;


}
    