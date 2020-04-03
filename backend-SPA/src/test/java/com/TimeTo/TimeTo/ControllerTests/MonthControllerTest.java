package com.TimeTo.TimeTo.ControllerTests;

import com.TimeTo.TimeTo.Controllers.MonthController;
import com.TimeTo.TimeTo.Models.Calendar;
import com.TimeTo.TimeTo.Models.Month;
import com.TimeTo.TimeTo.Repositories.DayRepository;
import com.TimeTo.TimeTo.Repositories.MonthRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;
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

@DirtiesContext
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
        testMonth = new Month("testMonth", 1, 1, 2020, testCalendar);
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

    @Test
    public void underTestIsWiredCorrectlyWithAnnotations() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(get("/months/"))
                .andExpect(status().isOk());
    }

    @Test
    public void retrieveSingleMonthReturnsASingleMonth(){
        Month result = underTest.retrieveSingleMonth(2L);
        verify(monthRepository).findById(2L);
        assertThat(result).isEqualTo(testMonth);
    }
}
