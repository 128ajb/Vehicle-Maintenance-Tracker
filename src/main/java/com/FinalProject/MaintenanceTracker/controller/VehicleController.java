package com.FinalProject.MaintenanceTracker.controller;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.FinalProject.MaintenanceTracker.mapper.VehicleMapper;
import com.FinalProject.MaintenanceTracker.model.Vehicle;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class VehicleController {

    private final VehicleMapper vehicleMapper;

    public VehicleController(VehicleMapper vehicleMapper) {
        this.vehicleMapper = vehicleMapper;
    }

    @GetMapping("/vehicles")
    public String viewVehicles(
            Model model,
            HttpSession session){

        Integer userId = 
            (Integer) session.getAttribute("userId");

        List<Vehicle> vehicles =
            vehicleMapper.findByUserId(userId);

        model.addAttribute("vehicles", vehicles);

        return "vehicles";
    }

    @GetMapping("/vehicles/add")
    public String addVehiclePage() {
        return "VehicleAdd";
    }
    @PostMapping("/vehicles/save")
    public String saveVehicle(
            @ModelAttribute Vehicle vehicle,
            HttpSession session){

        Integer userId = (Integer) session.getAttribute("userId");

        vehicle.setUserId(userId);

        vehicleMapper.insert(vehicle);

        return "redirect:/vehicles";
    }
    @PostMapping("/vehicles/delete")
    public String deleteVehicle(
            String vin,
            HttpSession session) {

        vehicleMapper.delete(vin);

        return "redirect:/vehicles";
    }
}