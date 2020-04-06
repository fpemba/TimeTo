package com.TimeTo.TimeTo.Models;

import com.TimeTo.TimeTo.Models.Day;
import com.TimeTo.TimeTo.Models.UserAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {

    @Id
    private String id;
    @ManyToMany
    private Set<UserAccount> userAccounts;
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
    public Event(String id, Day day, boolean available, LocalTime startTime, LocalTime endTime, String name) {
        this.id = id;
        this.day = day;
        this.available = available;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        userAccounts = new HashSet<>();
    }

    public Collection<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    public void addUser(UserAccount user){
        userAccounts.add(user);
    }

//    public Party getParty() {
//        return party;
//    }

    public Day getDay() {
        return day;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", available=" + available +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", name='" + name + '\'' +
                '}';
    }
}
