package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.RefundChargeFee;
import com.nuriddin.myCinemaRoom.projection.CustomRefundChargeFee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.UUID;

@RepositoryRestResource(path = "refundChargeFee" , collectionResourceRel = "refundChargeFeeList",excerptProjection = CustomRefundChargeFee.class)
public interface RefundChargeFeeRepository extends JpaRepository<RefundChargeFee, UUID> {

}
