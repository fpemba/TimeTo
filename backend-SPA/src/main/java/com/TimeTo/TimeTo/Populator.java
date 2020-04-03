package com.TimeTo.TimeTo;

import com.TimeTo.TimeTo.Models.Calendar;
import com.TimeTo.TimeTo.Models.Day;
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
        createAprilDays(april2020);

        Month may2020 = new Month("May", 5, 6, 2020, masterCalendar);
        monthRepository.save(may2020);
        createMayDays(may2020);

        Month june2020 = new Month("June", 6, 2, 2020, masterCalendar);
        monthRepository.save(june2020);
        createJuneDays(june2020);

        Month july2020 = new Month("July", 7 , 4, 2020, masterCalendar);
        monthRepository.save(july2020);
        createJulyDays(july2020)


        Month august2020 = new Month("August", 8, 7, 2020, masterCalendar);
        monthRepository.save(august2020);
        createAugustDays(august2020);


        Month september2020 = new Month("September", 9, 3, 2020, masterCalendar);
        monthRepository.save(september2020);
        createSeptemberDays(september2020);

        Month october2020 = new Month("October", 10, 5, 2020, masterCalendar);
        monthRepository.save(october2020);
        createOctoberDays(october2020);

        Month november2020 = new Month("November", 11, 1, 2020, masterCalendar);
        monthRepository.save(november2020);
        createNovemberDays(november2020);

        Month december2020 = new Month("December", 12, 3, 2020, masterCalendar);
        monthRepository.save(december2020);
        createDecemberDays(december2020);

    }
    private void createAprilDays(Month april) {
        for(int i = 1 ; i < 31; i ++){
            Day newDay = new Day(april, i);
            dayRepository.save(newDay);
        }
    }
    private void createMayDays(Month may){
        for(int i = 1; i < 32; i++){
            Day newDay = new Day(may, i);
            dayRepository.save(newDay);
        }
    }
    private void createJuneDays(Month june) {
        for(int i = 1 ; i < 31; i ++){
            Day newDay = new Day(june, i);
            dayRepository.save(newDay);
        }
    }
    private void createJulyDays(Month july){
        for(int i = 1; i < 32; i++){
            Day newDay = new Day(july, i);
            dayRepository.save(newDay);
        }
    }
    private void createAugustDays(Month august){
        for(int i = 1; i < 32; i++){
            Day newDay = new Day(august, i);
            dayRepository.save(newDay);
        }
    }
    private void createSeptemberDays(Month september) {
        for(int i = 1 ; i < 31; i ++){
            Day newDay = new Day(september, i);
            dayRepository.save(newDay);
        }
    }
    private void createOctoberDays(Month october){
        for(int i = 1; i < 32; i++){
            Day newDay = new Day(october, i);
            dayRepository.save(newDay);
        }
    }
    private void createNovemberDays(Month november) {
        for(int i = 1 ; i < 31; i ++){
            Day newDay = new Day(november, i);
            dayRepository.save(newDay);
        }
    }
    private void createDecemberDays(Month december){
        for(int i = 1; i < 32; i++){
            Day newDay = new Day(december, i);
            dayRepository.save(newDay);
        }
    }
}

