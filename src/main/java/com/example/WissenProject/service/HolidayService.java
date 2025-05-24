package com.example.WissenProject.service;

import com.example.WissenProject.entity.Holiday;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class HolidayService {
    private final Map<UUID, Holiday> holidays = new ConcurrentHashMap<>();

    public List<Holiday> getAll() {
        populateWeekends(2025);
        return new ArrayList<>(holidays.values());
    }

    public void populateWeekends(int year) {
        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);

        while (!start.isAfter(end)) {
            DayOfWeek day = start.getDayOfWeek();
            if ((day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY)) {
                LocalDate finalStart = start;
                boolean alreadyPresent = holidays.values().stream()
                        .anyMatch(h -> h.getDate().equals(finalStart));

                if (!alreadyPresent) {
                    String name = (day == DayOfWeek.SATURDAY) ? "Saturday" : "Sunday";
                    holidays.put(UUID.randomUUID(), new Holiday(UUID.randomUUID(), name, start ));
                }
            }
            start = start.plusDays(1);
        }
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
