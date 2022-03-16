package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.Cart;
import com.nuriddin.myCinemaRoom.projection.CustomCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;


@RepositoryRestResource(path = "cart" , collectionResourceRel = "cartList",excerptProjection = CustomCart.class)
public interface CartRepository extends JpaRepository<Cart, UUID> {

}
