package com.TimeTo.TimeTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CalendarControllerTest {
   private CalendarRepository calendarRepository;
   private CalendarController underTest;
   private Calendar testCalendar;

   @BeforeEach
    void setUp(){
       calendarRepository = mock(CalendarRepository.class);
       underTest = new CalendarController(calendarRepository);
       testCalendar = new Calendar();
       when(calendarRepository.findAll()).thenReturn(Collections.singletonList(testCalendar));
       when(calendarRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(testCalendar));
   }

    @Test
    public void retrieveCalendarsReturnsListOfCalendarsFromMockRepo(){
        underTest.retrieveCalendars();
        verify(calendarRepository).findAll();
    }

    @Test
    public void retrieveArtistsReturnsListOfArtistsContainingMockArtist(){
        Collection<Calendar> result = underTest.retrieveCalendars();
        assertThat(result).contains(testCalendar);
    }


//    @Test
//  public void underTestIsWiredCorrectlyWithAnnotations() throws Exception{
//       MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
//       mockMvc.perform(get("/calendars/"))
//               .andExpect(status().isOk());
//  }

   @Test
    public void retrieveSingleCalendarReturnsASingleCalendar(){
       Calendar result = underTest.retrieveSingleCalendar(1L);
       verify(calendarRepository).findById(1L);
       assertThat(result).isEqualTo(testCalendar);
   }
}
