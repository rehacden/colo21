package com.colo.repository;

import com.colo.data.items.Item;
import com.colo.data.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE i.owner = ?1")
    List<Item> findByOwnder(User owner);

    @Query("SELECT i FROM Item i WHERE i.code = ?1")
    Item findByCode(int code);
}
