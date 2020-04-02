package com.TimeTo.TimeTo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class CalendarController {
    private CalendarRepository calendarRepository;

    public CalendarController(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    @GetMapping("/calendars/")
    public Collection<Calendar> retrieveCalendars() {
        return (Collection<Calendar>) calendarRepository.findAll();
    }

    @GetMapping("/calendars/{id}/")
    public Calendar retrieveSingleCalendar(@PathVariable Long id) {
        return calendarRepository.findById(id).get();
    }


}
