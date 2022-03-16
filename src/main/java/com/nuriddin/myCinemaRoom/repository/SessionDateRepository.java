package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.SessionDate;
import com.nuriddin.myCinemaRoom.projection.CustomSessionDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.UUID;

@RepositoryRestResource(path = "sessionDate" , collectionResourceRel = "sessionDateList",excerptProjection = CustomSessionDate.class)
public interface SessionDateRepository extends JpaRepository<SessionDate, UUID> {

}
