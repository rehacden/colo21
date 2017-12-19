package com.colo.controller;

import com.colo.dao.DaoImpl;
import com.colo.data.Purchase;
import com.colo.data.items.Item;
import com.colo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rehacek on 10/1/2017.
 */
@Controller
public class ItemsController {

    @Autowired private DaoImpl dao;
    @Autowired private ItemRepository itemRepository;

    @ModelAttribute("items")
    public List<Item> index() {
        return itemRepository.findAll();
    }

    @GetMapping("/items")
    public String items() {
        return "items";
    }

    @GetMapping("/item/{code}")
    public String item(@PathVariable(value = "code") String code, Model model) {
        Item item = itemRepository.findByCode(Integer.parseInt(code));
        model.addAttribute("item", item);
        return "item";
    }

    @PostMapping("/item/{code}/purchase")
    public String purchase(@PathVariable(value = "code") String code,
                           @ModelAttribute("purchase") Purchase purchase) {

        return "order";
    }
}
