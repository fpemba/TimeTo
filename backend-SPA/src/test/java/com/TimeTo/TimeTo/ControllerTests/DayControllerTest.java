//package com.TimeTo.TimeTo.ControllerTests;
//
//import com.TimeTo.TimeTo.Controllers.DayController;
//import com.TimeTo.TimeTo.Models.*;
//import com.TimeTo.TimeTo.Repositories.DayRepository;
//import com.TimeTo.TimeTo.Repositories.EventRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.time.LocalTime;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@DirtiesContext
//public class DayControllerTest {
//    private DayRepository dayRepository;
//    private EventRepository eventRepository;
//    private DayController underTest;
//    private Calendar testCalendar;
//    private Month testMonth;
//    private Day testDay;
//    private Event testEvent;
//    private MockMvc mockMvc;
//    private UserAccount testUser;
//    private Account testAccount;

//    @BeforeEach
//    void setUp(){
//        dayRepository = mock(DayRepository.class);
//        eventRepository = mock(EventRepository.class);
//        underTest = new DayController(dayRepository);
//        testCalendar = new Calendar();
//        testUser = new UserAccount("Simba", "Mufasason", "LionKing95");
//        testAccount = new Account(testUser, testCalendar);
//        testMonth = new Month("testMonth", 1,  1, 2020, testCalendar);
//        testDay = new Day("1", testMonth, 1);
//        LocalTime startTime = LocalTime.of(4,0,0);
//        LocalTime endTime = LocalTime.of(6,0,0);
//        testEvent = new Event(testAccount, "5",testDay, false, startTime, endTime, "Funzone");
//        when(dayRepository.findAll()).thenReturn(Collections.singletonList(testDay));
//        when(dayRepository.findById("1")).thenReturn(Optional.of(testDay));
//        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
//    }

//    @Test
//    public void retrieveDaysReturnsListOfDays(){
//        underTest.retrieveDays();
//        verify(dayRepository).findAll();
//    }
//
//    @Test
//    public void retrieveDaysReturnsListOfDaysContainingMockDay(){
//        Collection<Day> result = underTest.retrieveDays();
//        assertThat(result).contains(testDay);
//    }
//
//    @Test
//    public void underTestIsWiredCorrectly() throws Exception{
//        mockMvc.perform(get("/days/"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//   public void retrieveSingleDayReturnsASingleDay(){
//        Day result = underTest.retrieveSingleDay("1");
//        verify(dayRepository).findById("1");
//        assertThat(result).isEqualTo(testDay);
//    }
//}
