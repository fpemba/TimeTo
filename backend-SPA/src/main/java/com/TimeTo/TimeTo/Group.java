package com.TimeTo.TimeTo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Group {

    @Id
    @GeneratedValue
    private Long id;
    private String groupName;
    @ManyToMany
    private Collection<User> users;
    @OneToMany(mappedBy = "group")
    private Collection<Event> event;

    public Group(){

    }

    public Group(String groupName, Collection<User> users) {
        this.groupName = groupName;
        this.users = users;
    }

    public String getGroupName() {
        return groupName;
    }

    public Collection<User> getUsers() {
        return users;
    }
}
