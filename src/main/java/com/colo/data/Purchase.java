package com.colo.data;

import com.colo.data.items.Item;
import com.colo.data.users.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rehacek on 10/1/2017.
 */
@Entity
@Table(name="purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private User user;
    @OneToOne
    private Item item;

    private String message;
//    private Date created;
//    private Date from;
//    private Date to;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //    public Date getCreated() {
//        return created;
//    }
//
//    public void setCreated(Date created) {
//        this.created = created;
//    }
//
//    public Date getFrom() {
//        return from;
//    }
//
//    public void setFrom(Date from) {
//        this.from = from;
//    }
//
//    public Date getTo() {
//        return to;
//    }
//
//    public void setTo(Date to) {
//        this.to = to;
//    }
}
