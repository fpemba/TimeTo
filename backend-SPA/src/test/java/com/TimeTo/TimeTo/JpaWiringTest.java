package com.TimeTo.TimeTo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaWiringTest {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private DayRepository dayRepository;
    @Autowired
    private MonthRepository monthRepository;
    @Autowired
    private CalendarRepository calendarRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void EventsShouldHaveADay(){
        Calendar testCalendar = new Calendar();
        calendarRepository.save(testCalendar);

        Month testMonth = new Month(testCalendar);
        monthRepository.save(testMonth);

        Day testDay = new Day(testMonth);
        dayRepository.save(testDay);

        Event testEvent1 = new Event(testDay);
        eventRepository.save(testEvent1);

        Event testEvent2 = new Event(testDay);
        eventRepository.save(testEvent2);

        entityManager.flush();
        entityManager.clear();

        Day retrievedDay = dayRepository.findById(testDay.getId()).get();
        Event retrievedEvent1 = eventRepository.findById(testEvent1.getId()).get();
        Event retrievedEvent2 = eventRepository.findById(testEvent2.getId()).get();
        assertThat(retrievedDay.getEvents()).contains(retrievedEvent1, retrievedEvent2);
    }

    @Test
    public void DaysShouldHaveAMonth(){
        Calendar testCalendar = new Calendar();
        calendarRepository.save(testCalendar);

        Month testMonth = new Month(testCalendar);
        monthRepository.save(testMonth);

        Day testDay1 = new Day(testMonth);
        dayRepository.save(testDay1);

        Day testDay2 = new Day(testMonth);
        dayRepository.save(testDay2);

        entityManager.flush();
        entityManager.clear();

        Month retrievedMonth = monthRepository.findById(testMonth.getId()).get();
        Day retrievedDay1 = dayRepository.findById(testDay1.getId()).get();
        Day retrievedDay2 = dayRepository.findById(testDay2.getId()).get();
        assertThat(retrievedMonth.getDays()).contains(retrievedDay1, retrievedDay2);
    }

    @Test
    public void MonthsHaveACalendar(){
        Calendar testCalendar = new Calendar();
        calendarRepository.save(testCalendar);

        Month testMonth1 = new Month(testCalendar);
        monthRepository.save(testMonth1);

        Month testMonth2 = new Month(testCalendar);
        monthRepository.save(testMonth2);

        entityManager.flush();
        entityManager.clear();

        Calendar retrievedCalendar = calendarRepository.findById(testCalendar.getId()).get();
        Month retrievedMonth1 = monthRepository.findById(testMonth1.getId()).get();
        Month retrievedMonth2 = monthRepository.findById(testMonth2.getId()).get();
        assertThat(retrievedCalendar.getMonths()).contains(retrievedMonth1, retrievedMonth2);
    }
}
