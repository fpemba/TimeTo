package com.TimeTo.TimeTo.Models;

import com.TimeTo.TimeTo.Models.Day;
import com.TimeTo.TimeTo.Models.Party;
import com.TimeTo.TimeTo.Models.UserAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    private Collection<UserAccount> userAccounts;
    @ManyToOne
    private Party party;

    @JsonIgnore
    @ManyToOne
    private Day day;


    public Event() {

    }
    public Event(Day day) {
        this.day = day;
    }



    public Collection<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    public Party getParty() {
        return party;
    }

    public Day getDay() {
        return day;
    }

    public Long getId() {
        return id;
    }
}
