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
    private User user;

    public Calendar() {

    }

    public Calendar(Month month, Day day, Year year, User user) {
        this.month = month;
        this.year = year;
        this.user = user;
    }

    public Month getMonth() {
        return month;
    }

    public Year getYear() {
        return year;
    }

    public User getUser() {
        return user;
    }
}





