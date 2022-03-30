package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Row;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

//@Transactional

@RepositoryRestResource(path = "raw" , collectionResourceRel = "rawList")
public interface RowRepository extends JpaRepository<Row, Long> {

}
