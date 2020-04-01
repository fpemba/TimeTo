package com.TimeTo.TimeTo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    private Collection<User> users;
    @ManyToOne
    private Group group;
    @ManyToMany
    private Collection<Day> day;


    public Event() {

    }
    public Event(Collection<User> users, Group group,Collection<Day> day) {
        this.users = users;
        this.group = group;
        this.day = day;
    }



    public Collection<User> getUsers() {
        return users;
    }

    public Group getGroup() {
        return group;
    }

    public Collection<Day> getDay() {
        return day;
    }
}
