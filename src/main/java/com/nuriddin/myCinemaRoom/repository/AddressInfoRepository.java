package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.AddressInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "addressInfo" , collectionResourceRel = "addressInfo")
public interface AddressInfoRepository extends JpaRepository<AddressInfo, Long> {

    public AddressInfo findByTown(String town);

}
