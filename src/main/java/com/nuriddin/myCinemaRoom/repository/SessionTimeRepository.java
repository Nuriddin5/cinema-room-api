package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.SessionTime;
import com.nuriddin.myCinemaRoom.projection.CustomSessionTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.UUID;

@RepositoryRestResource(path = "sessionTime" , collectionResourceRel = "sessionTimeList",excerptProjection = CustomSessionTime.class)
public interface SessionTimeRepository extends JpaRepository<SessionTime, UUID> {

}
