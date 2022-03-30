package com.nuriddin.myCinemaRoom.repository;

import com.nuriddin.myCinemaRoom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
