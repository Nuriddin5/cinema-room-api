package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AttConRepo extends JpaRepository<AttachmentContent, UUID> {
    Optional<AttachmentContent> findByAttachmentId(UUID attachment_id);
}
