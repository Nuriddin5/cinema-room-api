package com.nuriddin.myCinemaRoom.repository;


import com.nuriddin.myCinemaRoom.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttachmentRepo extends JpaRepository<Attachment, UUID> {
}
