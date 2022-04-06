package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Announcement;
import com.nuriddin.myCinemaRoom.entity.MovieSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

//@RepositoryRestResource(path = "movieSession" , collectionResourceRel = "movieSessionList")
public interface MovieSessionRepository extends JpaRepository<MovieSession, Long> {

    @Query(nativeQuery = true,
    value = "select m.name from ticket t " +
            "join movie_session ms on ms.id = t.movie_session_id" +
            " join announcement a on ms.announcement_id = a.id " +
            "join movie_contract mc on a.movie_contract_id = mc.id " +
            "join movie m on mc.movie_id = m.id where t.id  = :ticketId")
    public String findMovieNameByTicketId(UUID ticketId);


}
