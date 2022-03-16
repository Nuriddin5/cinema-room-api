package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Row;
import com.nuriddin.myCinemaRoom.projection.CustomRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "raw" , collectionResourceRel = "rawList",excerptProjection = CustomRow.class)
public interface RowRepository extends JpaRepository<Row, UUID> {

}
