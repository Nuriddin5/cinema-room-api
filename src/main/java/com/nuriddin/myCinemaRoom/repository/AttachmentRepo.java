package com.nuriddin.myCinemaRoom.repository;


import com.nuriddin.myCinemaRoom.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepo extends JpaRepository<Attachment, Long> {
}
