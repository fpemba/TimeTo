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
    private int length;
    @OneToMany(mappedBy = "month")
    private Collection<Day> days;

    public Month() {
    }

    public Long getId() {
        return id;
    }

    public Month(String name, int numberOfMonth, int firstDayOfMonth, int year, Calendar calendar, int length) {
        this.name = name;
        this.numberOfMonth = numberOfMonth;
        this.firstDayOfMonth = firstDayOfMonth;
        this.year = year;
        this.calendar = calendar;
        this.length = length;
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

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Month month = (Month) o;

        if (numberOfMonth != month.numberOfMonth) return false;
        if (firstDayOfMonth != month.firstDayOfMonth) return false;
        if (year != month.year) return false;
        if (length != month.length) return false;
        if (id != null ? !id.equals(month.id) : month.id != null) return false;
        if (name != null ? !name.equals(month.name) : month.name != null) return false;
        return calendar != null ? calendar.equals(month.calendar) : month.calendar == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + numberOfMonth;
        result = 31 * result + firstDayOfMonth;
        result = 31 * result + year;
        result = 31 * result + (calendar != null ? calendar.hashCode() : 0);
        result = 31 * result + length;
        return result;
    }
}
