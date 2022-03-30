package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "cart" , collectionResourceRel = "cartList")
public interface CartRepository extends JpaRepository<Cart, Long> {

}
