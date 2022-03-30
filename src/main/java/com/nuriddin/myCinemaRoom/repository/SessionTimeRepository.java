package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.SessionTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalTime;

@RepositoryRestResource(path = "sessionTime" , collectionResourceRel = "sessionTimeList")
public interface SessionTimeRepository extends JpaRepository<SessionTime, Long> {
    public SessionTime findByTime(LocalTime time);

}
