package com.TimeTo.TimeTo.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Party {

    @Id
    @GeneratedValue
    private Long id;
    private String groupName;
    @ManyToMany
    private Collection<UserAccount> userAccounts;
    @OneToMany(mappedBy = "party")
    private Collection<Event> event;

    public Party(){

    }

    public Party(String groupName, Collection<UserAccount> userAccounts) {
        this.groupName = groupName;
        this.userAccounts = userAccounts;
    }

    public String getGroupName() {
        return groupName;
    }

    public Collection<UserAccount> getUserAccounts() {
        return userAccounts;
    }
}
