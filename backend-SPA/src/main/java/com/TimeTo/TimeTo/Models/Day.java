package com.TimeTo.TimeTo.Models;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Day {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Month month;
    @OneToMany(mappedBy = "day")
    private Collection<Event> events;
    private int dayNumber;

    public Day(){

    }
    public Day(Month month, int dayNumber) {
        this.month = month;
        this.dayNumber = dayNumber;
    }

    public Month getMonth() {
        return month;
    }

    public Collection<Event> getEvents() {
        return events;
    }

    public Long getId() {
        return id;
    }

    public int getDayNumber() {
        return dayNumber;
    }
}
