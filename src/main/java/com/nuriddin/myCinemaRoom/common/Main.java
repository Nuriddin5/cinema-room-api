package com.nuriddin.myCinemaRoom.common;


// t.me/superJavaDeveloper 30.03.2022;

//import lombok.*;
//import lombok.experimental.FieldDefaults;
//
//import javax.persistence.Entity;
//import java.util.UUID;
//
//@EqualsAndHashCode(callSuper = true)
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity

public class Main {
    public static void main(String[] args) {
        double productPrice = 29.450;
        double commissionFee = 2.9000000000000000000000000;
        double extraFee = 0.30000000000000000000000000000;

        Double stripegaBeribYuboriladiganSumma = (productPrice * (1 + commissionFee / 100) + 2 * extraFee) / (1 - commissionFee / 100);
        System.out.println(stripegaBeribYuboriladiganSumma);

        double clientDanYechiladiganSumma = stripegaBeribYuboriladiganSumma - (commissionFee * stripegaBeribYuboriladiganSumma / 100) - extraFee;
        System.out.println(clientDanYechiladiganSumma);

        System.out.println(clientDanYechiladiganSumma - productPrice*commissionFee/100 - 0.3);
    }
}
