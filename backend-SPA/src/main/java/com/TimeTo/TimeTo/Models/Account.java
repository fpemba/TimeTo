package com.TimeTo.TimeTo.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private UserAccount userAccount;
    @ManyToMany
    private Set<UserAccount> friends;

    protected Account(){

    }

    public Account(UserAccount userAccount){
        friends = new HashSet<>();
        this.userAccount = userAccount;
    }

    public Long getId() {
        return id;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public Set<UserAccount> getFriends() {
        return friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void addFriend(UserAccount friend) {
        friends.add(friend);
    }
}
