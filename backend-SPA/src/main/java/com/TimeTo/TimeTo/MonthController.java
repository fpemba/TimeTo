package com.TimeTo.TimeTo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MonthController {
    private MonthRepository monthRepository;
    private DayRepository dayRepository;

    public MonthController(MonthRepository monthRepository, DayRepository dayRepository){
        this.monthRepository = monthRepository;
        this.dayRepository = dayRepository;
    }

    @GetMapping("/months/")
    public Collection<Month> retrieveMonths() {
        return (Collection<Month>) monthRepository.findAll();
    }
}
