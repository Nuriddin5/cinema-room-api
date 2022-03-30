package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "distributor" , collectionResourceRel = "distributorList")
public interface DistributorRepository extends JpaRepository<Distributor, Long> {

}
