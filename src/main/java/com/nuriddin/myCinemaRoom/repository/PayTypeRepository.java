package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.PayType;
import com.nuriddin.myCinemaRoom.projection.CustomPayType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.UUID;

@RepositoryRestResource(path = "payType" , collectionResourceRel = "payTypeList",excerptProjection = CustomPayType.class)
public interface PayTypeRepository extends JpaRepository<PayType, UUID> {

}
