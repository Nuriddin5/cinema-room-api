package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.RefundChargeFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "refundChargeFee" , collectionResourceRel = "refundChargeFeeList")
public interface RefundChargeFeeRepository extends JpaRepository<RefundChargeFee, Long  > {

}
