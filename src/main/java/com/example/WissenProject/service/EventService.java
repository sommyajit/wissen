package com.example.WissenProject.service;

import com.example.WissenProject.entity.Event;
import com.example.WissenProject.entity.enums.EventStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class EventService {
    private final Map<UUID, Event> events = new ConcurrentHashMap<>();

    public List<Event> getAll() {
        return events.values().stream()
                .map(this::withStatus)
                .collect(Collectors.toList());
    }

    public Event add(Event event) {
        event.setId(UUID.randomUUID());
        events.put(event.getId(), event);
        return event;
    }

    private Event withStatus(Event event) {
        LocalDateTime now = LocalDateTime.now();
        EventStatus status = event.getDateTime().isAfter(now) ? EventStatus.UPCOMING :
                event.getDateTime().isBefore(now.minusHours(1)) ? EventStatus.COMPLETED :
                        EventStatus.ONGOING;
        return new Event(event.getId(), event.getTitle(), event.getDescription(), event.getDateTime(), status);
    }

    public Map<LocalDate, List<Event>> getEventsByDay(int year) {
        return events.values().stream()
                .filter(e -> e.getDateTime().getYear() == year)
                .map(this::withStatus)
                .collect(Collectors.groupingBy(e -> e.getDateTime().toLocalDate()));
    }

}
