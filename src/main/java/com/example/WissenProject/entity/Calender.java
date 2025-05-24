package com.example.WissenProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calender {
    private boolean isHoliday;
    private String holidayName;
    private List<Event> events;
}
