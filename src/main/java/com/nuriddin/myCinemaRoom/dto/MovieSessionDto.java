package com.nuriddin.myCinemaRoom.dto;


// t.me/superJavaDeveloper 09.04.2022;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nuriddin.myCinemaRoom.entity.SessionDate;
import com.nuriddin.myCinemaRoom.entity.SessionTime;
import com.nuriddin.myCinemaRoom.entity.Theatre;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
//@FieldDefaults(level = AccessLevel.PRIVATE)

public class MovieSessionDto {
    Long theatreId;


    Long sessionDateId;

    @NotNull
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "hh:mm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm")
    String startTime;

    @NotNull
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "hh:mm")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="hh:mm")
    String endTime;

    Long AnnouncementId;

}
