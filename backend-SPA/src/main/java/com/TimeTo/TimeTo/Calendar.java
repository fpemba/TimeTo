package com.TimeTo.TimeTo;


import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity
public class Calendar {

    @Id
    @GeneratedValue
    private Long id;
    private Month month;
    private Year year;
    @OneToOne
    private UserAccount userAccount;

    public Calendar() {

    }

    public Calendar(Month month, Day day, Year year, UserAccount userAccount) {
        this.month = month;
        this.year = year;
        this.userAccount = userAccount;
    }

    public Month getMonth() {
        return month;
    }

    public Year getYear() {
        return year;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }
}





