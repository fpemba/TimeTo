package com.TimeTo.TimeTo;

import com.TimeTo.TimeTo.Models.Calendar;
import com.TimeTo.TimeTo.Models.Day;
import com.TimeTo.TimeTo.Models.Event;
import com.TimeTo.TimeTo.Models.Month;
import com.TimeTo.TimeTo.Repositories.CalendarRepository;
import com.TimeTo.TimeTo.Repositories.DayRepository;
import com.TimeTo.TimeTo.Repositories.EventRepository;
import com.TimeTo.TimeTo.Repositories.MonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

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
        createJulyDays(july2020);


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
    private void createJanuaryDays(Month january) {
        for(int i = 1 ; i < 31; i ++){
            String idToSet;
            if(i < 10){
                idToSet = "01-0" + i + "-" + january.getYear();
            } else {
                idToSet = "01-" + i + "-" + january.getYear();
            }
            Day newDay = new Day(idToSet, january, i);
            dayRepository.save(newDay);
            createHours(newDay);
        }
    }

    private void createFebruaryDays(Month february) {
        for(int i = 1 ; i < 31; i ++){
            String idToSet;
            if(i < 10){
                idToSet = "02-0" + i + "-" + february.getYear();
            } else {
                idToSet = "02-" + i + "-" + february.getYear();
            }
            Day newDay = new Day(idToSet, february, i);
            dayRepository.save(newDay);
            createHours(newDay);
        }
    }

    private void createMarchDays(Month march) {
        for(int i = 1 ; i < 32; i ++){
            String idToSet;
            if(i < 10){
                idToSet = "03-0" + i + "-" + march.getYear();
            } else {
                idToSet = "03-" + i + "-" + march.getYear();
            }
            Day newDay = new Day(idToSet, march, i);
            dayRepository.save(newDay);
            createHours(newDay);
        }
    }

    private void createAprilDays(Month april) {
        for(int i = 1 ; i < 31; i ++){
            String idToSet;
            if(i < 10){
                idToSet = "04-0" + i + "-" + april.getYear();
            } else {
                idToSet = "04-" + i + "-" + april.getYear();
            }
            Day newDay = new Day(idToSet, april, i);
            dayRepository.save(newDay);
            createHours(newDay);
        }
    }
    private void createMayDays(Month may){
        for(int i = 1; i < 32; i++){
            String idToSet;
            if(i < 10){
                idToSet = "05-0" + i + "-" + may.getYear();
            } else {
                idToSet = "05-" + i + "-" + may.getYear();
            }
            Day newDay = new Day(idToSet, may, i);
            dayRepository.save(newDay);
            createHours(newDay);
        }
    }
    private void createJuneDays(Month june) {
        for(int i = 1 ; i < 31; i ++){
            String idToSet;
            if(i < 10){
                idToSet = "06-0" + i + "-" + june.getYear();
            } else {
                idToSet = "06-" + i + "-" + june.getYear();
            }
            Day newDay = new Day(idToSet, june, i);
            dayRepository.save(newDay);
            createHours(newDay);
        }
    }
    private void createJulyDays(Month july){
        for(int i = 1; i < 32; i++){
            String idToSet;
            if(i < 10){
                idToSet = "07-0" + i + "-" + july.getYear();
            } else {
                idToSet = "07-" + i + "-" + july.getYear();
            }
            Day newDay = new Day(idToSet, july, i);
            dayRepository.save(newDay);
            createHours(newDay);
        }
    }
    private void createAugustDays(Month august){
        for(int i = 1; i < 32; i++){
            String idToSet;
            if(i < 10){
                idToSet = "08-0" + i + "-" + august.getYear();
            } else {
                idToSet = "08-" + i + "-" + august.getYear();
            }
            Day newDay = new Day(idToSet, august, i);
            dayRepository.save(newDay);
            createHours(newDay);
        }
    }
    private void createSeptemberDays(Month september) {
        for(int i = 1 ; i < 31; i ++){
            String idToSet;
            if(i < 10){
                idToSet = "09-0" + i + "-" + september.getYear();
            } else {
                idToSet = "09-" + i + "-" + september.getYear();
            }
            Day newDay = new Day(idToSet, september, i);
            dayRepository.save(newDay);
            createHours(newDay);
        }
    }
    private void createOctoberDays(Month october){
        for(int i = 1; i < 32; i++){
            String idToSet;
            if(i < 10){
                idToSet = "10-0" + i + "-" + october.getYear();
            } else {
                idToSet = "10-" + i + "-" + october.getYear();
            }
            Day newDay = new Day(idToSet, october, i);
            dayRepository.save(newDay);
            createHours(newDay);
        }
    }
    private void createNovemberDays(Month november) {
        for(int i = 1 ; i < 31; i ++){
            String idToSet;
            if(i < 10){
                idToSet = "11-0" + i + "-" + november.getYear();
            } else {
                idToSet = "11-" + i + "-" + november.getYear();
            }
            Day newDay = new Day(idToSet, november, i);
            dayRepository.save(newDay);
            createHours(newDay);
        }
    }
    private void createDecemberDays(Month december){
        for(int i = 1; i < 32; i++){
            String idToSet;
            if(i < 10){
                idToSet = "12-0" + i + "-" + december.getYear();
            } else {
                idToSet = "12-" + i + "-" + december.getYear();
            }
            Day newDay = new Day(idToSet, december, i);
            dayRepository.save(newDay);
            createHours(newDay);
        }
    }

    private void createHours(Day day){
        for(int h =1; h<25; h++){
            LocalTime startTime = LocalTime.of(h,0,0);
            LocalTime endTime = LocalTime.of(h+1, 0, 0);
            Event newHour = new Event(day, true, startTime, endTime, "Free Time");
            eventRepository.save(newHour);
        }
    }

}

