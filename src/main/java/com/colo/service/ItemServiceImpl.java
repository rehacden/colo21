package com.colo.service;

import com.colo.data.items.Item;
import com.colo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository repository;

    @Override
    public void save(Item item) {
        repository.save(item);
    }
}
