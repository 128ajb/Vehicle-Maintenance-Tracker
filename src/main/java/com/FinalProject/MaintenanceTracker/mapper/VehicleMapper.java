package com.FinalProject.MaintenanceTracker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.FinalProject.MaintenanceTracker.model.Vehicle;

@Mapper
public interface VehicleMapper {

    List<Vehicle> findByUserId(Integer userId);

    void insert(Vehicle vehicle);
    void delete(String vin);

    List<Vehicle> findAll();





}