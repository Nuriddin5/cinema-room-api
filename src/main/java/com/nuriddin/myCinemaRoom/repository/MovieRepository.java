package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Movie;
import com.nuriddin.myCinemaRoom.projection.CustomMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "movie" , collectionResourceRel = "movieList",excerptProjection = CustomMovie.class)
public interface MovieRepository extends JpaRepository<Movie, UUID> {

//    @RestResource(path = "nameStartWith")
//    public Page<Movie> findByNameStartingWith(@Param("name") String name, Pageable pageable);
}
