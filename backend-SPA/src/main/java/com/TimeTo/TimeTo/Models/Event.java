package com.TimeTo.TimeTo.Models;

import com.TimeTo.TimeTo.Models.Day;
import com.TimeTo.TimeTo.Models.UserAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Collection;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    private Collection<UserAccount> userAccounts;
//    @ManyToOne
//    private Party party;
    private boolean available;
    private LocalTime startTime;
    private LocalTime endTime;
    private String name;

    @JsonIgnore
    @ManyToOne
    private Day day;


    public Event() {

    }
    public Event(Day day, boolean available, LocalTime startTime, LocalTime endTime, String name) {
        this.day = day;
        this.available = available;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
    }

    public Collection<UserAccount> getUserAccounts() {
        return userAccounts;
    }

//    public Party getParty() {
//        return party;
//    }

    public Day getDay() {
        return day;
    }

    public Long getId() {
        return id;
    }

}
