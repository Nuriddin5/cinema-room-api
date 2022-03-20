package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.File;
import com.nuriddin.myCinemaRoom.projection.CustomFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "file" , collectionResourceRel = "fileList",excerptProjection = CustomFile.class)
public interface FileRepository extends JpaRepository<File, UUID> {

//    @RestResource(path = "nameStartWith")
//    public Page<File> findByNameStartingWith(@Param("name") String name, Pageable pageable);
}
