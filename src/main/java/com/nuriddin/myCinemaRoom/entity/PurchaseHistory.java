package com.nuriddin.myCinemaRoom.entity;

import com.nuriddin.myCinemaRoom.entity.template.AbsLongEntity;
import com.nuriddin.myCinemaRoom.enums.PaymentStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class PurchaseHistory extends AbsLongEntity {

    double totalAmount;

    @ManyToMany
    @JoinTable(
            name = "payment_histories_tickets",
            joinColumns = @JoinColumn(name = "purchase_history_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id")
    )
    List<Ticket> ticketList;


    //    @ManyToOne
//    PayType payType;
    @Enumerated(EnumType.STRING)
    PaymentStatus paymentStatus;

    boolean idRefunded;

    String stripePaymentIntent;

}
    