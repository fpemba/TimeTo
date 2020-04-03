package com.TimeTo.TimeTo.Models;



import javax.persistence.*;
import java.util.Collection;

@Entity
public class Day {

    @Id
    @GeneratedValue
    private Long id;
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
