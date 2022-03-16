package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.Attachment;

import java.util.UUID;

public interface CustomAttachment {
    UUID getId();

    String getFileName();

    String getContentType();

    Long getSize();

    AttachmentContentInfo getAttachmentContent();

    interface AttachmentContentInfo {
        UUID getId();

        byte[] getData();

        Attachment getAttachment();
    }
}
