package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Location;
import com.nuriddin.myCinemaRoom.projection.CustomLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "location" , collectionResourceRel = "location",excerptProjection = CustomLocation.class)
public interface LocationRepository extends JpaRepository<Location, Long> {
    public Location findByLongtitude(String longtitude);

}
