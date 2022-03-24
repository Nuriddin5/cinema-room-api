package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Theatre;
import com.nuriddin.myCinemaRoom.projection.CustomTheatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "theatre" , collectionResourceRel = "theatreList",excerptProjection = CustomTheatre.class)
public interface TheatreRepository extends JpaRepository<Theatre, Long> {

}
