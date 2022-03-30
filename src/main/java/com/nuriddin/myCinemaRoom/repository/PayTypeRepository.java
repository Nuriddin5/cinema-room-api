package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.PayType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "payType" , collectionResourceRel = "payTypeList")
public interface PayTypeRepository extends JpaRepository<PayType, Long> {

}
