package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.CashBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cashBox" , collectionResourceRel = "cashBoxList")
public interface CashboxRepository extends JpaRepository<CashBox, Long> {

}
