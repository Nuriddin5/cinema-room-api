package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "movie" , collectionResourceRel = "movieList")
public interface MovieRepository extends JpaRepository<Movie, Long> {

    public Movie findByName(String name);


}
