package com.TimeTo.TimeTo.Controllers;

import com.TimeTo.TimeTo.Models.Event;
import com.TimeTo.TimeTo.Repositories.EventRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Collection;
import java.util.Optional;

@RestController
public class EventController {
    private EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events/")
    public Collection<Event> retrieveEvents() {
        return (Collection<Event>) eventRepository.findAll();
    }

    @GetMapping("/events/{id}/")
    public Optional<Event> retrieveEventById(@PathVariable Long id) {
        return eventRepository.findById(id);
    }

    @GetMapping("/events/{startTime}/")
    public Optional<Event> retrieveEventByStartTime(@PathVariable LocalTime startTime){
        return eventRepository.findByStartTime(startTime);
    }

    @DeleteMapping("/events/{id}/")
    public void deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
    }

    @PostMapping("/events/")
    public Event createEvent(@RequestBody Event eventToAdd) {
        return eventRepository.save(eventToAdd);
    }
}
