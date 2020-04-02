package com.TimeTo.TimeTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

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
}
