package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.AttachmentContent;
import com.nuriddin.myCinemaRoom.projection.CustomAttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;


@RepositoryRestResource(path = "attachment-content" , collectionResourceRel = "attachmentContentList",excerptProjection = CustomAttachmentContent.class)
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, UUID> {

//    @RestResource(path = "nameStartWith")
//    public Page<AttachmentContent> findByNameStartingWith(@Param("name") String name, Pageable pageable);
}
