package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

//@Transactional

@RepositoryRestResource(path = "theatre" , collectionResourceRel = "theatreList")
public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    public Theatre findByName(String name);

}
