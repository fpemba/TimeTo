package com.TimeTo.TimeTo;


import javax.persistence.*;
import java.time.Year;
import java.util.Collection;

@Entity
public class Calendar {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "calendar")
    private Collection<Month> months;

    private Year year;
    @OneToOne
    private UserAccount userAccount;

    public Calendar() {

    }

    public Calendar(Year year, UserAccount userAccount) {
        this.year = year;
        this.userAccount = userAccount;
    }

    public Collection<Month> getMonths() {
        return months;
    }

    public Year getYear() {
        return year;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public Long getId() {
        return id;
    }
}





