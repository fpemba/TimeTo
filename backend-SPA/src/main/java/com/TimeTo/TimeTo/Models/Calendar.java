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
    @OneToOne
    private Account account;

    public Calendar(Account account){
        this.account = account;
    }

    public Calendar(){

    }

    public Collection<Month> getMonths() {
        return months;
    }

    public Long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calendar calendar = (Calendar) o;

        if (id != null ? !id.equals(calendar.id) : calendar.id != null) return false;
        return account != null ? account.equals(calendar.account) : calendar.account == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        return result;
    }
}





