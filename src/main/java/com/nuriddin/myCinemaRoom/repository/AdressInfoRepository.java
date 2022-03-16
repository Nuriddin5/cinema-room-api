package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.AddressInfo;
import com.nuriddin.myCinemaRoom.projection.CustomAddressInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "addressInfo" , collectionResourceRel = "addressInfoList",excerptProjection = CustomAddressInfo.class)
public interface AdressInfoRepository extends JpaRepository<AddressInfo, UUID> {

}
