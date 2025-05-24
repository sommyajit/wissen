package com.example.WissenProject.service;

import com.example.WissenProject.dto.CalendarDayInfo;
import com.example.WissenProject.entity.Event;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalenderService {
    private final HolidayService holidayService;
    private final EventService eventService;

    public CalenderService(HolidayService holidayService, EventService eventService) {
        this.holidayService = holidayService;
        this.eventService = eventService;
    }

    public Map<LocalDate, CalendarDayInfo> getCalendar(int year) {
        Map<LocalDate, String> holidays = holidayService.getHolidayMap(year);
        Map<LocalDate, List<Event>> events = eventService.getEventsByDay(year);

        LocalDate start = LocalDate.of(year, 1, 1);
        LocalDate end = LocalDate.of(year, 12, 31);
        Map<LocalDate, CalendarDayInfo> calendar = new LinkedHashMap<>();

        while (!start.isAfter(end)) {
            boolean isHoliday = holidays.containsKey(start);
            String holidayName = holidays.get(start);
            List<Event> dayEvents = events.getOrDefault(start, new ArrayList<>());

            calendar.put(start, new CalendarDayInfo(isHoliday, holidayName, dayEvents));
            start = start.plusDays(1);
        }

        return calendar;
    }
}
