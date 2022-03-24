package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.City;
import com.nuriddin.myCinemaRoom.projection.CustomCity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.UUID;

@RepositoryRestResource(path = "city" , collectionResourceRel = "city",excerptProjection = CustomCity.class)
public interface CityRepository extends JpaRepository<City, Long> {

    @RestResource(path = "nameStartWith")
    public Page<City> findByNameStartingWith(@Param("name") String name, Pageable pageable);
}
