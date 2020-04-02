package com.TimeTo.TimeTo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class DayController {
    private DayRepository dayRepository;
    private EventRepository eventRepository;

    public DayController(DayRepository dayRepository, EventRepository eventRepository){
        this.dayRepository = dayRepository;
        this.eventRepository = eventRepository;
    }

    @GetMapping("/days/")
    public Collection<Day> retrieveDays() {
        return (Collection<Day>) dayRepository.findAll();
    }
}
