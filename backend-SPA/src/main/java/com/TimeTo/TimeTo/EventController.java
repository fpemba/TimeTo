package com.TimeTo.TimeTo;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
public class EventController {
    private EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("/events")
    public Collection<Event> retrieveEvents() {
        return (Collection<Event>) eventRepository.findAll();
    }
    @GetMapping("/events/{id}")
    public Optional<Event> retrieveEventById(@PathVariable Long id) {
        return eventRepository.findById(id);
    }
    @DeleteMapping("/events/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
    }
    @PostMapping("/events")
    public Event createEvent(@RequestBody Event eventToAdd) {
        return eventRepository.save(eventToAdd);
    }
}
