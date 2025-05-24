package com.example.WissenProject.controller;


import com.example.WissenProject.dto.CalendarDayInfo;
import com.example.WissenProject.service.CalenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/calendar")
public class CalenderController {

    @Autowired
    private final CalenderService calendarService;

    public CalenderController(CalenderService calendarService) {
        this.calendarService = calendarService;
    }


    @GetMapping("/{year}")
    public Map<LocalDate, CalendarDayInfo> getCalendar(@PathVariable int year) {
        return calendarService.getCalendar(year);
    }
}
