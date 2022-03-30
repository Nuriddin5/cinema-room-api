package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Movie;
import com.nuriddin.myCinemaRoom.entity.MovieContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "movieContract" , collectionResourceRel = "movieContractList")
public interface MovieContractRepository extends JpaRepository<MovieContract, Long> {
//    public Movie findByN

}
