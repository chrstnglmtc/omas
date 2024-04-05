package com.omasystem.omas.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.omasystem.omas.Model.TimetableModel;

@Mapper
public interface TimetableDao {
    // Get the list of reserved seats based on a specific time range
    List<TimetableModel> getAllReservationPerTimeslot(Map<String, String> parameters);

    // Get the list of reserved seats based on its start date
    List<TimetableModel> getAllReservationStartDate(String parameter);
}