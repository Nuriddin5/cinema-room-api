package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Announcement;
import com.nuriddin.myCinemaRoom.projection.CustomAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "announcement" , collectionResourceRel = "announcementList",excerptProjection = CustomAnnouncement.class)
public interface AnnouncementRepository extends JpaRepository<Announcement, UUID> {

}
