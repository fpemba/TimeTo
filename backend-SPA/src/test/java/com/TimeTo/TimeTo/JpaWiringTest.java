package com.TimeTo.TimeTo;

import com.TimeTo.TimeTo.Models.*;
import com.TimeTo.TimeTo.Repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@DirtiesContext
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
    @Autowired
    private AccountRepository accountRepository;
//    @Autowired
//    private PersonRepository personRepository;

//    @Test
//    public void accountShouldHaveUserAndAFriendsList(){
//        UserAccount testUser = new UserAccount("Tom", "Henderson", "Henderson81");
//        userRepository.save(testUser);
//
//        Calendar testCalendar = new Calendar();
//
//        Account testAccount = new Account(testUser, testCalendar);
//        accountRepository.save(testAccount);
//
//        UserAccount testFriend = new UserAccount("John", "Sad", "SadJohn");
//        userRepository.save(testFriend);
//        testAccount.addFriend(testFriend);
//        accountRepository.save(testAccount);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        UserAccount retrievedUser = userRepository.findById(testUser.getId()).get();
//        assertThat(retrievedUser.getAccount()).isEqualTo(testAccount);
//        assertThat(retrievedUser.getAccount().getFriends()).contains(testFriend);
//    }
//
//    @Test
//    public void EventsShouldHaveADay(){
//        Calendar testCalendar = new Calendar();
//        calendarRepository.save(testCalendar);
//
//        Month testMonth = new Month("testMonth", 1, 1, 2020, testCalendar);
//        monthRepository.save(testMonth);
//
//        Day testDay = new Day("1", testMonth, 1);
//        dayRepository.save(testDay);
//
//        LocalTime start = LocalTime.of(8,0,0);
//        LocalTime end = LocalTime.of(10,0,0);
//
//        Event testEvent1 = new Event("1000", testDay, false, start, end, "Yay");
//        eventRepository.save(testEvent1);
//
//        Event testEvent2 = new Event("10002", testDay, false, start, end, "Happy");
//        eventRepository.save(testEvent2);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Day retrievedDay = dayRepository.findById(testDay.getId()).get();
//        Event retrievedEvent1 = eventRepository.findById(testEvent1.getId()).get();
//        Event retrievedEvent2 = eventRepository.findById(testEvent2.getId()).get();
//        assertThat(retrievedDay.getEvents()).contains(retrievedEvent1, retrievedEvent2);
//    }
//
//    @Test
//    public void DaysShouldHaveAMonth(){
//        Calendar testCalendar = new Calendar();
//        calendarRepository.save(testCalendar);
//
//        Month testMonth = new Month("testMonth", 1, 1, 2020, testCalendar);
//        monthRepository.save(testMonth);
//
//        Day testDay1 = new Day("1", testMonth, 1);
//        dayRepository.save(testDay1);
//
//        Day testDay2 = new Day("1", testMonth, 2);
//        dayRepository.save(testDay2);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Month retrievedMonth = monthRepository.findById(testMonth.getId()).get();
//        Day retrievedDay1 = dayRepository.findById(testDay1.getId()).get();
//        Day retrievedDay2 = dayRepository.findById(testDay2.getId()).get();
//        assertThat(retrievedMonth.getDays()).contains(retrievedDay1, retrievedDay2);
//    }
//
//    @Test
//    public void MonthsHaveACalendar(){
//        Calendar testCalendar = new Calendar();
//        calendarRepository.save(testCalendar);
//
//        Month testMonth1 = new Month("testMonth1", 1, 1, 2020, testCalendar);
//        monthRepository.save(testMonth1);
//
//        Month testMonth2 = new Month("testMonth2", 2, 2, 2020, testCalendar);
//        monthRepository.save(testMonth2);
//
//        entityManager.flush();
//        entityManager.clear();
//
//        Calendar retrievedCalendar = calendarRepository.findById(testCalendar.getId()).get();
//        Month retrievedMonth1 = monthRepository.findById(testMonth1.getId()).get();
//        Month retrievedMonth2 = monthRepository.findById(testMonth2.getId()).get();
//        assertThat(retrievedCalendar.getMonths()).contains(retrievedMonth1, retrievedMonth2);
//    }
}
