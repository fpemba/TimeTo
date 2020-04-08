package com.TimeTo.TimeTo.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Month {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int numberOfMonth;
    private int firstDayOfMonth;
    private int year;

    @JsonIgnore
    @ManyToOne
    private Calendar calendar;
    @OneToMany(mappedBy = "month")
    private Collection<Day> days;

    public Month() {
    }

    public Long getId() {
        return id;
    }

    public Month(String name, int numberOfMonth, int firstDayOfMonth, int year, Calendar calendar) {
        this.name = name;
        this.numberOfMonth = numberOfMonth;
        this.firstDayOfMonth = firstDayOfMonth;
        this.year = year;
        this.calendar = calendar;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public Collection<Day> getDays() {
        return days;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfMonth() {
        return numberOfMonth;
    }

    public int getFirstDayOfMonth() {
        return firstDayOfMonth;
    }

    public int getYear() {
        return year;
    }
}
