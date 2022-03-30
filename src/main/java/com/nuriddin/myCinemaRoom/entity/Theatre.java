package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 15.03.2022;

import com.nuriddin.myCinemaRoom.entity.template.AbsLongEntity;
import com.nuriddin.myCinemaRoom.entity.template.AbsUUIDEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
//@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Theatre extends AbsLongEntity {
    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String telephone_number;

    @ManyToOne
    City city;

    @OneToOne
    AddressInfo address_info;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    List<Row> rows;

    public Theatre(String name, String telephone_number, City city, AddressInfo address_info) {
        this.name = name;
        this.telephone_number = telephone_number;
        this.city = city;
        this.address_info = address_info;
    }

    @Override
    public String toString() {
        return "Theatre{" +
               "name='" + name + '\'' +
               ", telephone_number='" + telephone_number + '\'' +
               ", city=" + city +
               ", address_info=" + address_info +
               '}';
    }
}
