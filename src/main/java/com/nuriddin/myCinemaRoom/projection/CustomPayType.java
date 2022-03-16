package com.nuriddin.myCinemaRoom.projection;

import java.sql.Timestamp;
import java.util.UUID;

public interface CustomPayType {
    UUID getId();


    String getName();

    AttachmentInfo getLogo();

    interface AttachmentInfo {
        UUID getId();

        Timestamp getCreatedAt();

        Timestamp getUpdatedAt();

        UUID getCreatedBy();

        UUID getUpdatedBy();

        String getFileOriginalName();

        Long getSize();

        String getContentType();

        String getUniqueName();
    }
}
