package com.colo.repository;

import com.colo.data.users.User;
import com.colo.data.users.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
//    @Query("select username from user join pu")//TODO
//    UserProjection findById();
}