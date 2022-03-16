package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.MovieSession;
import com.nuriddin.myCinemaRoom.projection.CustomMovieSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.UUID;

@RepositoryRestResource(path = "movieSession" , collectionResourceRel = "movieSessionList",excerptProjection = CustomMovieSession.class)
public interface MovieSessionRepository extends JpaRepository<MovieSession, UUID> {

}
