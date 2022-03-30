package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Seat;
import com.nuriddin.myCinemaRoom.projection.AvailableSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@Transactional

@RepositoryRestResource(path = "seat" , collectionResourceRel = "seatList")
public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query(value = "select s.id,\n" +
                   "       s.number as seatNumber,\n" +
                   "       r.number as rowNumber,\n" +
                   "       true as available\n" +
                   "\n" +
                   "       from seat s\n" +
                   "join row r on r.id = s.row_id\n" +
                   "join theatre t on r.theatre_id = t.id\n" +
                   "join movie_session ms on t.id = ms.theatre_id\n" +
                   "where s.id not in(\n" +
                   "    select t2.seat_id from ticket t2\n" +
                   "    join movie_session m on t2.movie_session_id = m.id\n" +
                   "    where t2.status <> 'REFUNDED' and t2.movie_session_id = :sessionId\n" +
                   "    ) and ms.id =:sessionId\n" +
                   "union\n" +
                   "select s2.id,\n" +
                   "       s2.number as seatNumber,\n" +
                   "       r2.number as rowNumber,\n" +
                   "       false as available\n" +
                   " from ticket t3\n" +
                   "join seat s2 on t3.seat_id = s2.id\n" +
                   "join row r2 on s2.row_id = r2.id\n" +
                   "join movie_session ms2 on ms2.id = t3.movie_session_id\n" +
                   "where t3.status <>'REFUNDED' and ms2.id = :sessionId\n",nativeQuery = true)
    List<AvailableSeat> getAvailableSeatsInSession(Long sessionId);

}
