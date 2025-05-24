package com.example.WissenProject.dto;

import com.example.WissenProject.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CalendarDayInfo {
    private boolean isHoliday;
    private String holidayName;
    private List<Event> events;

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setHoliday(boolean holiday) {
        isHoliday = holiday;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public void setHolidayName(String holidayName) {
        this.holidayName = holidayName;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public CalendarDayInfo(boolean isHoliday, String holidayName, List<Event> events) {
        this.isHoliday = isHoliday;
        this.holidayName = holidayName;
        this.events = events;
    }


}

