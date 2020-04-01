package com.TimeTo.TimeTo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
//    @OneToOne
//    private FriendList friendList;
    @OneToMany
    private Collection<Party> parties;

    public UserAccount() {

    }

    public UserAccount(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
//        this.friendList = friendList;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

//    public FriendList getFriendList() {
//        return friendList;
//    }

    public Collection<Party> getParties() {
        return parties;
    }
}
