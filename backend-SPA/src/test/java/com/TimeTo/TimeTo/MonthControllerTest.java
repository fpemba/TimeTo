package com.TimeTo.TimeTo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

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
//        when(monthRepository.findById(2L)).thenReturn(java.util.Optional.ofNullable(testMonth));

    }

    @Test
    public void retrieveMonthsReturnsAListOfMonthsFromMockRepo(){
        underTest.retrieveMonths();
        verify(monthRepository).findAll();
    }
}
