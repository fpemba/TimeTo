package com.TimeTo.TimeTo.Repositories;

import com.TimeTo.TimeTo.Models.Event;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalTime;
import java.util.Optional;

public interface EventRepository extends CrudRepository <Event, Long>{
    Optional<Event> findByStartTime(LocalTime startTime);
}
