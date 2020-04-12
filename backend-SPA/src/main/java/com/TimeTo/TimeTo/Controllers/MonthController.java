package com.TimeTo.TimeTo.Controllers;

import com.TimeTo.TimeTo.Repositories.DayRepository;
import com.TimeTo.TimeTo.Models.Month;
import com.TimeTo.TimeTo.Repositories.MonthRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class MonthController {
    private MonthRepository monthRepository;

    public MonthController(MonthRepository monthRepository) {
        this.monthRepository = monthRepository;
    }

    @GetMapping("/months/")
    public Collection<Month> retrieveMonths() {
        return (Collection<Month>) monthRepository.findAll();
    }

    @GetMapping("/months/{id}/")
    public Month retrieveSingleMonth(@PathVariable String id) {
        return monthRepository.findById(id).get();
    }
}
