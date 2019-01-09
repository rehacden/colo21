package com.colo.data.items;

import com.colo.data.Address;
import com.colo.data.Location;
import com.colo.data.users.User;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rehacek on 8/25/2017.
 */
//@EntityScan
@Entity
@Table(name="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int code;
    private String name;
    private String description;
    private String type;
    @ManyToOne
    private User owner;
    @OneToOne
    private Location location;
    @OneToOne
    private Address address;

//    @ManyToMany
//    private List<Avaibility> avaibility;

    public Item() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

//    public List<Avaibility> getAvaibility() {
//        return avaibility;
//    }
//
//    public void setAvaibility(List<Avaibility> avaibility) {
//        this.avaibility = avaibility;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String  name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
