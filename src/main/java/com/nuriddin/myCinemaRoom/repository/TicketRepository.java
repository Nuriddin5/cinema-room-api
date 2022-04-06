package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Ticket;
import com.nuriddin.myCinemaRoom.enums.TicketStatus;
import com.nuriddin.myCinemaRoom.projection.ViewTickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;
@RepositoryRestResource(path = "ticket")
public interface TicketRepository extends JpaRepository<Ticket, UUID> {

//    @Query(nativeQuery = true,
//    value = "")
//    void getTicketsInCartByUserId(UUID user_id);

    List<ViewTickets> findAllByUserIdAndStatus(UUID userId, TicketStatus status);
}
