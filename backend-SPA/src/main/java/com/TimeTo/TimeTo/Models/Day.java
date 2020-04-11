package com.TimeTo.TimeTo.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Day {

    @Id
    private String id;

    @JsonIgnore
    @ManyToOne
    private Month month;
    @OneToMany(mappedBy = "day")
    private Collection<Event> events;
    private int dayNumber;

    public Day() {

    }

    public Day(String id, Month month, int dayNumber) {
        this.id = id;
        this.month = month;
        this.dayNumber = dayNumber;
    }

    public String getMonth() {
        return month.getName();
    }

    public Collection<Event> getEvents() {
        return events;
    }

    public String getId() {
        return id;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    @Override
    public String toString() {
        return "Day{" +
                "id='" + id + '\'' +
                ", month=" + month +
                ", events=" + events +
                ", dayNumber=" + dayNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Day day = (Day) o;

        if (dayNumber != day.dayNumber) return false;
        if (id != null ? !id.equals(day.id) : day.id != null) return false;
        return month != null ? month.equals(day.month) : day.month == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + dayNumber;
        return result;
    }
}
