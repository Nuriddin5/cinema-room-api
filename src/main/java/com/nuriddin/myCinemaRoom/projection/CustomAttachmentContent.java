package com.nuriddin.myCinemaRoom.projection;

import com.nuriddin.myCinemaRoom.entity.AttachmentContent;

import java.util.UUID;

public interface CustomAttachmentContent {
    AttachmentInfo getAttachment();

    interface AttachmentInfo {
        UUID getId();

        String getFileName();

        String getContentType();

        Long getSize();

        AttachmentContent getAttachmentContent();
    }
}
