package com.example.WissenProject.controller;

import com.example.WissenProject.entity.Holiday;
import com.example.WissenProject.service.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    private final HolidayService service;

    public HolidayController(HolidayService service) {
        this.service = service;
    }

    @GetMapping
    public List<Holiday> all() {
        return service.getAll();
    }

    @PostMapping
    public Holiday add(@RequestBody Holiday holiday) {
        return service.add(holiday);
    }

    @GetMapping("/next")
    public Holiday next() {
        return service.getNextHoliday();
    }
}
