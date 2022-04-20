package com.nuriddin.myCinemaRoom.entity;


import com.nuriddin.myCinemaRoom.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class BillingInfo extends AbsLongEntity {

    @ManyToOne()
    User user;

    @Column(nullable = false)
    String cardHolderName;

    @Column(nullable = false, unique = true)
    String cardNumber;

    @Column(nullable = false)
    LocalDate expirationDate;

    @Column(nullable = false)
    Byte cvc;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BillingInfo that = (BillingInfo) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
    