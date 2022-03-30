package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.SessionDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;

@RepositoryRestResource(path = "sessionDate" , collectionResourceRel = "sessionDateList")
public interface SessionDateRepository extends JpaRepository<SessionDate, Long> {
    public SessionDate findByDate(LocalDate date);

}
