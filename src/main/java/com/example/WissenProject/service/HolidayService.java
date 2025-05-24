package com.example.WissenProject.service;

import com.example.WissenProject.entity.Holiday;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class HolidayService {
    private final Map<UUID, Holiday> holidays = new ConcurrentHashMap<>();

    public List<Holiday> getAll() {
        return new ArrayList<>(holidays.values());
    }

    public Holiday add(Holiday holiday) {
        holiday.setId(UUID.randomUUID());
        holidays.put(holiday.getId(), holiday);
        return holiday;
    }

    public Holiday getNextHoliday() {
        return holidays.values().stream()
                .filter(h -> h.getDate().isAfter(LocalDate.now()))
                .min(Comparator.comparing(Holiday::getDate))
                .orElse(null);
    }

    public Map<LocalDate, String> getHolidayMap(int year) {
        return holidays.values().stream()
                .filter(h -> h.getDate().getYear() == year)
                .collect(Collectors.toMap(Holiday::getDate, Holiday::getName));
    }

}
