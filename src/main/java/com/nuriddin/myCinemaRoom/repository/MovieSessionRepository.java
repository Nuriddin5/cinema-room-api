package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Announcement;
import com.nuriddin.myCinemaRoom.entity.MovieSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource(path = "movieSession" , collectionResourceRel = "movieSessionList")
public interface MovieSessionRepository extends JpaRepository<MovieSession, Long> {


}
