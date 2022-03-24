package com.nuriddin.myCinemaRoom.entity;


// t.me/superJavaDeveloper 09.03.2022;

import com.nuriddin.myCinemaRoom.entity.template.AbsLongEntity;
import com.nuriddin.myCinemaRoom.entity.template.AbsUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class AttachmentContent extends AbsLongEntity {


   private byte[] content;

   @OneToOne
   private Attachment attachment;
}
