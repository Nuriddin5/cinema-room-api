package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Attachment;
import com.nuriddin.myCinemaRoom.projection.CustomAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "attachment" , collectionResourceRel = "attachmentList",excerptProjection = CustomAttachment.class)
public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {

//    @RestResource(path = "nameStartWith")
//    public Page<Attachment> findByNameStartingWith(@Param("name") String name, Pageable pageable);
}
