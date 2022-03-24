package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Distributor;
import com.nuriddin.myCinemaRoom.projection.CustomDistributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "distributor" , collectionResourceRel = "distributorList",excerptProjection = CustomDistributor.class)
public interface DistributorRepository extends JpaRepository<Distributor, Long> {

}
