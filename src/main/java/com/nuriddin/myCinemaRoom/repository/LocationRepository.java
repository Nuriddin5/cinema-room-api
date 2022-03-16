package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Location;
import com.nuriddin.myCinemaRoom.projection.CustomLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "location" , collectionResourceRel = "locationList",excerptProjection = CustomLocation.class)
public interface LocationRepository extends JpaRepository<Location, UUID> {

//    @RestResource(path = "nameStartWith")
//    public Page<Location> findByNameStartingWith(@Param("name") String name, Pageable pageable);
}
