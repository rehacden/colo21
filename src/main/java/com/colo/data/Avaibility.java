package com.colo.data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by rehacek on 10/1/2017.
 */
//@Entity
//@Table(name="avaibility")
public class Avaibility {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @Temporal(TemporalType.TIMESTAMP)
    private Date from;
//    @Temporal(TemporalType.TIMESTAMP)
    private Date to;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

}
