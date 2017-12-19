package com.colo.controller;

import com.colo.data.Location;
import com.colo.data.items.Item;
import com.colo.data.users.User;
import com.colo.repository.AddressRepository;
import com.colo.repository.ItemRepository;
import com.colo.repository.LocationRepository;
import com.colo.repository.UserRepository;
import com.colo.service.GoogleApiService;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired private UserRepository userRepository;
    @Autowired private ItemRepository itemRepository;
    @Autowired private AddressRepository addressRepository;
    @Autowired private GoogleApiService googleApiService;
    @Autowired private LocationRepository locationRepository;

//    @GetMapping("/user/{username}")
//    public String getTemplate(@PathVariable(value="username") String username, Model model) {
//        model.addAttribute(userRepository.findByUsername(username));
//        return "user";
//    }

    @GetMapping("/user")
    public String getTemplate(Model model){
//        User user = getUser();
//        model.addAttribute("user", getUser());
//        model.addAttribute("t", getUser());
        return "user";
    }
    @ModelAttribute("user")
    public User user() {
        return getUser();
    }

    @ModelAttribute("items")
    public List<Item> items() {
        return itemRepository.findByOwnder(getUser());
    }

    @PostMapping("/user")
    public String getTemplate(){
        return "user";
    }

    private User getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object user = auth.getPrincipal();
            if (user instanceof org.springframework.security.core.userdetails.User) {
                User myUser = userRepository.findByUsername(((org.springframework.security.core.userdetails.User) user).getUsername());
                return myUser;
            }
        }
        return null;
    }

    @PostMapping("/user/addItem")
    public String addItem(@ModelAttribute("item") Item item, BindingResult result, Model model) throws InterruptedException, ApiException, IOException {
        item.setOwner(getUser());
        item.setCode(generateCode());

        LatLng location = googleApiService.getLocation(item.getAddress().addressQuery());
        if (location != null) {
            Location loc = new Location(location.lat, location.lng);
            item.setLocation(loc);
            locationRepository.save(loc);
        }
        addressRepository.save(item.getAddress());
        itemRepository.save(item);
        return "redirect:item/" + item.getCode();
    }

    private int generateCode() {
        return Math.toIntExact(hashCode());
    }
}
