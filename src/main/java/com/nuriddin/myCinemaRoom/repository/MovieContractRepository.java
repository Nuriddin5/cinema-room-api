package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.MovieContract;
import com.nuriddin.myCinemaRoom.projection.CustomMovieContract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.UUID;

@RepositoryRestResource(path = "movieContract" , collectionResourceRel = "movieContractList",excerptProjection = CustomMovieContract.class)
public interface MovieContractRepository extends JpaRepository<MovieContract, UUID> {

}
