package com.nuriddin.myCinemaRoom.entity;

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
public class RefundChargeFee extends AbsEntity {

    @Column(nullable = false)
    Integer intervalInMin;

    @Column(nullable = false)
    Double feeInPercentage;


}
    