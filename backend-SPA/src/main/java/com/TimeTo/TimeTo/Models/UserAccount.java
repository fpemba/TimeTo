package com.TimeTo.TimeTo.Models;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    @OneToOne(mappedBy = "userAccount")
    private Account account;
    @ManyToMany(mappedBy = "friends")
    private Set<Account> friendAccounts;

    public UserAccount() {

    }

    public UserAccount(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
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

    public Set<Account> getFriendAccounts(){
        return friendAccounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName);
    }

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "firstName='" + firstName + '\'' +
                '}';
    }
}
