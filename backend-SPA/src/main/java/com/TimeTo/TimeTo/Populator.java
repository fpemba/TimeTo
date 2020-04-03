package com.TimeTo.TimeTo;

import com.TimeTo.TimeTo.Models.Calendar;
import com.TimeTo.TimeTo.Models.Month;
import com.TimeTo.TimeTo.Repositories.CalendarRepository;
import com.TimeTo.TimeTo.Repositories.DayRepository;
import com.TimeTo.TimeTo.Repositories.EventRepository;
import com.TimeTo.TimeTo.Repositories.MonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private MonthRepository monthRepository;

    @Autowired
    private DayRepository dayRepository;

    @Autowired
    private EventRepository eventRepository;


    @Override
    public void run(String... args) throws Exception {
        Calendar masterCalendar = new Calendar();
        calendarRepository.save(masterCalendar);

        Month april2020 = new Month("April", 4, 4, 2020, masterCalendar);
        monthRepository.save(april2020);
        Month may2020 = new Month("May", 5, 6, 2020, masterCalendar);
        monthRepository.save(may2020);
        Month june2020 = new Month("June", 6, 2, 2020, masterCalendar);
        monthRepository.save(june2020);
        Month july2020 = new Month("July", 7 , 4, 2020, masterCalendar);
        monthRepository.save(july2020);
        Month august2020 = new Month("August", 8, 7, 2020, masterCalendar);
        monthRepository.save(august2020);
        Month september2020 = new Month("September", 9, 3, 2020, masterCalendar);
        monthRepository.save(september2020);
        Month october2020 = new Month("October", 10, 5, 2020, masterCalendar);
        monthRepository.save(october2020);
        Month november2020 = new Month("November", 11, 1, 2020, masterCalendar);
        monthRepository.save(november2020);
        Month december2020 = new Month("December", 12, 3, 2020, masterCalendar);
        monthRepository.save(december2020);
    }
}
