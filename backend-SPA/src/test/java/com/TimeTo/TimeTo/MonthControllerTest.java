package com.TimeTo.TimeTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MonthControllerTest {
    private MonthRepository monthRepository;
    private DayRepository dayRepository;
    private MonthController underTest;
    private Month testMonth;
    private Calendar testCalendar;

    @BeforeEach
    void setUp(){
        monthRepository = mock(MonthRepository.class);
        underTest = new MonthController(monthRepository, dayRepository);
        testCalendar = new Calendar();
        testMonth = new Month(testCalendar);
        when(monthRepository.findAll()).thenReturn(Collections.singletonList(testMonth));
        when(monthRepository.findById(2L)).thenReturn(java.util.Optional.ofNullable(testMonth));

    }

    @Test
    public void retrieveMonthsReturnsAListOfMonthsFromMockRepo(){
        underTest.retrieveMonths();
        verify(monthRepository).findAll();
    }

    @Test
    public void retrieveMonthsReturnsListOfMonthsContainingMockMonth(){
        Collection<Month> result = underTest.retrieveMonths();
        assertThat(result).contains(testMonth);
    }

//    @Test
//    public void underTestIsWiredCorrectlyWithAnnotations() throws Exception{
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
//        mockMvc.perform(get("/months/"))
//                .andExpect(status().isOk());
//    }

    @Test
    public void retrieveSingleMonthReturnsASingleMonth(){
        Month result = underTest.retrieveSingleMonth(2L);
        verify(monthRepository).findById(2L);
        assertThat(result).isEqualTo(testMonth);
    }
}