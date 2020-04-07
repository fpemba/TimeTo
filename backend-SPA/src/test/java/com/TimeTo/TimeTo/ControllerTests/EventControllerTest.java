package com.TimeTo.TimeTo.ControllerTests;

import com.TimeTo.TimeTo.Controllers.EventController;
import com.TimeTo.TimeTo.Models.Account;
import com.TimeTo.TimeTo.Models.Day;
import com.TimeTo.TimeTo.Models.Event;
import com.TimeTo.TimeTo.Repositories.DayRepository;
import com.TimeTo.TimeTo.Repositories.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EventControllerTest {
    private MockMvc mockMvc;
    private EventController eventController;
    private EventRepository eventRepo;
    private DayRepository dayRepo;
    private Account testAccount;
    private LocalTime startTime;
    private LocalTime endTime;

    @BeforeEach
    public void setUp(){
        eventRepo = mock(EventRepository.class);
        dayRepo = mock(DayRepository.class);
        eventController = new EventController(eventRepo);
        mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
        startTime = LocalTime.of(1, 0, 0);
        endTime = LocalTime.of(2, 0, 0);
    }

    @Test
    public void shouldRetrieveEvents() throws Exception{
        Day testDay = new Day();
    }

    @Test
    public void shouldRetrieveEventById() throws Exception{
        Day testDay = new Day();
        Event testEvent = new Event(testAccount, "1", testDay, false, startTime, endTime, "testName");
        when(eventRepo.findById(testEvent.getId())).thenReturn(java.util.Optional.of(testEvent));
        mockMvc.perform(MockMvcRequestBuilders.get("/events/1/"))
                .andExpect(status().isOk());
    }
}