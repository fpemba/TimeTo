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

//    @ManyToOne
//    private Party party;
    private boolean available;
    private LocalTime startTime;
    private LocalTime endTime;
    private String name;
    @JsonIgnore
    @ManyToOne
    private Account creator;
//    @ManyToMany
//    private Set<UserAccount> userAccounts;
    @JsonIgnore
    @ManyToOne
    private Day day;


    public Event() {

    }
    public Event(Account creator, String id, Day day, boolean available, LocalTime startTime, LocalTime endTime, String name) {
        this.creator = creator;
        this.id = id;
        this.day = day;
        this.available = available;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
//        userAccounts = new HashSet<>();
    }

//    public Collection<UserAccount> getUserAccounts() {
//        return userAccounts;
//    }
//
//    public void addUser(UserAccount user){
//        userAccounts.add(user);
//    }

//    public Party getParty() {
//        return party;
//    }

    public Day getDay() {
        return day;
    }

    public String getId() {
        return id;
    }

    public Account getCreator() {
        return creator;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (available != event.available) return false;
        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (startTime != null ? !startTime.equals(event.startTime) : event.startTime != null) return false;
        if (endTime != null ? !endTime.equals(event.endTime) : event.endTime != null) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        return day != null ? day.equals(event.day) : event.day == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (available ? 1 : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (day != null ? day.hashCode() : 0);
        return result;
    }

    public boolean isAvailable() {
        return available;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getName() {
        return name;
    }
}
