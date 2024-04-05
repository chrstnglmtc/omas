package com.omasystem.omas.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omasystem.omas.Model.TimetableModel;
import com.omasystem.omas.Service.TimetableService;

@RestController
@RequestMapping("/api/timetable")
public class TimetableController {

    @Autowired
    private final TimetableService timetableService;
    
    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    // Get the list of reserved seats based on a specific time range
    @GetMapping("/reservations")
    public List<TimetableModel> getAllReservationPerTimeslot(@RequestParam("start_date") String startDate, @RequestParam("end_date") String endDate) {
        
        Map<String, String> params = Map.of("start_date", startDate, "end_date", endDate);

        return timetableService.getAllReservationPerTimeslot(params);
    }

    // Get the list of reserved seats based on its start date
    @GetMapping("/reservations/start")
    public List<TimetableModel> getAllReservationStartDate(@RequestParam("start_date") String startDate) {
        return timetableService.getAllReservationStartDate(startDate);
    }
}