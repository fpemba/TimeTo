package com.TimeTo.TimeTo.Controllers;

import com.TimeTo.TimeTo.Models.Day;
import com.TimeTo.TimeTo.Repositories.DayRepository;
import com.TimeTo.TimeTo.Repositories.EventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping
    public Day retrieveSingleDay(@PathVariable String id) {
        return dayRepository.findById(id).get();
    }
}
