package com.TimeTo.TimeTo.ControllerTests;

import com.TimeTo.TimeTo.Controllers.DayController;
import com.TimeTo.TimeTo.Models.Calendar;
import com.TimeTo.TimeTo.Models.Day;
import com.TimeTo.TimeTo.Models.Event;
import com.TimeTo.TimeTo.Models.Month;
import com.TimeTo.TimeTo.Repositories.DayRepository;
import com.TimeTo.TimeTo.Repositories.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@DirtiesContext
public class DayControllerTest {
    private DayRepository dayRepository;
    private EventRepository eventRepository;
    private DayController underTest;
    private Calendar testCalendar;
    private Month testMonth;
    private Day testDay;
    private Event testEvent;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        dayRepository = mock(DayRepository.class);
        eventRepository = mock(EventRepository.class);
        underTest = new DayController(dayRepository, eventRepository);
        testCalendar = new Calendar();
        testMonth = new Month(testCalendar);
        testDay = new Day(testMonth);
        testEvent = new Event(testDay);
        when(dayRepository.findAll()).thenReturn(Collections.singletonList(testDay));
        when(dayRepository.findById(1L)).thenReturn(Optional.of(testDay));
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void retrieveDaysReturnsListOfDays(){
        underTest.retrieveDays();
        verify(dayRepository).findAll();
    }

    @Test
    public void retrieveDaysReturnsListOfDaysContainingMockDay(){
        Collection<Day> result = underTest.retrieveDays();
        assertThat(result).contains(testDay);
    }

//    @Test
//    public void underTestIsWiredCorrectly() throws Exception{
//        mockMvc.perform(get("/days/"))
//                .andExpect(status().isOk());
//    }

    @Test
   public void retrieveSingleDayReturnsASingleDay(){
        Day result = underTest.retrieveSingleDay(1L);
        verify(dayRepository).findById(1L);
        assertThat(result).isEqualTo(testDay);
    }
}
