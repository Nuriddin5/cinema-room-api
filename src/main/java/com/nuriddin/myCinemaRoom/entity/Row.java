package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 15.03.2022;

import com.nuriddin.myCinemaRoom.entity.template.AbsLongEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;
//@Transactional
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Row extends AbsLongEntity {
    @Column(nullable = false)
    Integer number;


    @ManyToOne(optional = false)
    private Theatre theatre;


    @OneToMany(mappedBy = "row",cascade = CascadeType.ALL)
    List<Seat> seats;

    public Row(Integer number, Theatre theatre) {
        this.number = number;
        this.theatre = theatre;
    }

    public Theatre getTheatres() {
        return theatre;
    }

    public void setTheatres(Theatre theatres) {
        this.theatre = theatres;
    }

    @Override
    public String toString() {
        return "Row{" +
               "number=" + number +
               ", theatre=" + theatre +
               '}';
    }
}
