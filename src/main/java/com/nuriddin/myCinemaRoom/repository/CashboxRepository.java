package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.CashBox;
import com.nuriddin.myCinemaRoom.projection.CustomCashBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "cashBox" , collectionResourceRel = "cashBoxList",excerptProjection = CustomCashBox.class)
public interface CashboxRepository extends JpaRepository<CashBox, UUID> {

}
