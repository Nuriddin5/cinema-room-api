package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.UUID;

//@RepositoryRestResource(path = "purchaseHistory" , collectionResourceRel = "purchaseHistory",excerptProjection = CustomPurchaseHistory.class)
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {

    @Query(nativeQuery = true,
    value = "select ph.* from purchase_history ph " +
            "join payment_histories_tickets pht on ph.id = pht.purchase_history_id " +
            "where pht.ticket_id = :ticketId " +
            "order by ph.created_at limit 1")
    PurchaseHistory getByTicketId(UUID ticketId);

//    @RestResource(path = "nameStartWith")
//    public Page<PurchaseHistory> findByNameStartingWith(@Param("name") String name, Pageable pageable);
//
//    public PurchaseHistory findByName(String name);
}
