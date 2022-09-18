package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 09.03.2022;

import com.nuriddin.myCinemaRoom.entity.template.AbsLongEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class
Attachment extends AbsLongEntity {

    private String fileOriginalName;

    private Long size;

    private String contentType;

    private String uniqueName;
}
