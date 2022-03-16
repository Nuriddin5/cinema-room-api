package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 09.03.2022;

import com.nuriddin.myCinemaRoom.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Attachment extends AbsEntity {

    private String fileOriginalName;

    private Long size;

    private String contentType;

    private String uniqueName;
}
