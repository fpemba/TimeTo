package com.TimeTo.TimeTo.Controllers;

import com.TimeTo.TimeTo.Models.Account;
import com.TimeTo.TimeTo.Models.Day;
import com.TimeTo.TimeTo.Models.Event;
import com.TimeTo.TimeTo.Repositories.AccountRepository;
import com.TimeTo.TimeTo.Repositories.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Optional;

@RestController
public class EventController {
    private EventRepository eventRepository;
    private AccountRepository accountRepository;

    public EventController(EventRepository eventRepository, AccountRepository accountRepository) {
        this.eventRepository = eventRepository;
        this.accountRepository = accountRepository;

    }

    @GetMapping("/events/")
    public Collection<Event> retrieveEvents() {
        return (Collection<Event>) eventRepository.findAll();
    }

    @GetMapping("/events/{username}/{month}/")
    public Collection<Event> retrieveEventByMonthAndUsername(@PathVariable ("username") String username, @PathVariable ("month") String month){
        return eventRepository.findByUsernameAndMonth(username, month);
    }

    @GetMapping("/events/{username}/")
    public Collection<Event> retrieveEventsByUsername(@PathVariable String username){
        return eventRepository.findByUsername(username);
    }

    @GetMapping("/event/{id}/")
    public Optional<Event> retrieveEventById(@PathVariable String id) {
        return eventRepository.findById(id);
    }

    @DeleteMapping("/event/{id}/")
    public void deleteEvent(@PathVariable String id) {
        Event e = eventRepository.findById(id).get();
        Event newFreeTime = new Event(e.getCreator(), e.getId(), e.getDay(), true, e.getStartTime(), e.getEndTime(), "Free Time!");
        eventRepository.deleteById(id);
        eventRepository.save(newFreeTime);
    }

    @PostMapping("/events/")
    public Event createEvent(@RequestBody Event event) {
        Account creator = event.getCreator();
        String id = event.getId();
        Day day = event.getDay();
        boolean available = false;
        LocalTime startTime = event.getStartTime();
        LocalTime endTime = event.getEndTime();
        String name = "Have fun";
        eventRepository.delete(event);
        Event eventToAdd = new Event(creator, id, day, available, startTime, endTime, name);
        return eventRepository.save(eventToAdd);
    }
}
