package com.example.WissenProject.controller;

import com.example.WissenProject.entity.Event;
import com.example.WissenProject.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public List<Event> all() {
        return service.getAll();
    }

    @PostMapping
    public Event add(@RequestBody Event event) {
        return service.add(event);
    }
}
