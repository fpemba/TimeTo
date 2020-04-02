package com.TimeTo.TimeTo.ControllerTests;

import com.TimeTo.TimeTo.Controllers.EventController;
import com.TimeTo.TimeTo.Models.Day;
import com.TimeTo.TimeTo.Models.Event;
import com.TimeTo.TimeTo.Repositories.DayRepository;
import com.TimeTo.TimeTo.Repositories.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EventControllerTest {
    private MockMvc mockMvc;
    private EventController eventController;
    private EventRepository eventRepo;
    private DayRepository dayRepo;

    @BeforeEach
    public void setUp(){
        eventRepo = mock(EventRepository.class);
        dayRepo = mock(DayRepository.class);
        eventController = new EventController(eventRepo);
        mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
    }

    @Test
    public void shouldRetrieveEvents() throws Exception{
        Day testDay = new Day();
    }

    @Test
    public void shouldRetrieveEventById() throws Exception{
        Day testDay = new Day();
        Event testEvent = new Event(testDay);
        when(eventRepo.findById(testEvent.getId())).thenReturn(java.util.Optional.of(testEvent));
        mockMvc.perform(MockMvcRequestBuilders.get("/events/1"))
                .andExpect(status().isOk());
    }
}