package com.TimeTo.TimeTo.Repositories;

import com.TimeTo.TimeTo.Models.Account;
import com.TimeTo.TimeTo.Models.Day;
import com.TimeTo.TimeTo.Models.Event;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Optional;

public interface EventRepository extends CrudRepository<Event, String> {
    Optional<Event> findByStartTime(LocalTime startTime);

//    void delete(Event retrievedEvent);

    Optional<Event> findById(String id);

   Collection<Event> findByUsername(String username);

   Collection<Event> findByUsernameAndMonth(String username, String month);

    Collection<Event> findByUsernameAndDay(String username, Day day);
}
