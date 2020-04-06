package com.TimeTo.TimeTo.Models;


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

    @OneToOne
    private UserAccount userAccount;

    public Calendar() {

    }

    public Calendar(UserAccount userAccount) {

        this.userAccount = userAccount;
    }

    public Collection<Month> getMonths() {
        return months;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calendar calendar = (Calendar) o;

        if (id != null ? !id.equals(calendar.id) : calendar.id != null) return false;
        return userAccount != null ? userAccount.equals(calendar.userAccount) : calendar.userAccount == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userAccount != null ? userAccount.hashCode() : 0);
        return result;
    }
}





