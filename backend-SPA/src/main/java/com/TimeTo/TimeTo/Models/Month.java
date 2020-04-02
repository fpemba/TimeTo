package com.TimeTo.TimeTo.Models;


import com.TimeTo.TimeTo.Models.Calendar;
import com.TimeTo.TimeTo.Models.Day;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Month {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Calendar calendar;
    @OneToMany(mappedBy = "month")
    private Collection<Day> days;

    public Month() {
    }

    public Long getId() {
        return id;
    }

    public Month(Calendar calendar) {
        this.calendar = calendar;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public Collection<Day> getDays() {
        return days;
    }
}
