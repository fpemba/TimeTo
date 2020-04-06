package com.TimeTo.TimeTo.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Year;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Calendar {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "calendar")
    private Collection<Month> months;

    @OneToMany(mappedBy= "calendar")
    private Set<Account> accounts;

    public Calendar(){
        accounts = new HashSet<>();
    }

    public Collection<Month> getMonths() {
        return months;
    }

    public Long getId() {
        return id;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calendar calendar = (Calendar) o;

        return id != null ? id.equals(calendar.id) : calendar.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}





