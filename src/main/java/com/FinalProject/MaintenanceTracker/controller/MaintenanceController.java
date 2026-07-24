package com.FinalProject.MaintenanceTracker.controller;


import org.springframework.stereotype.Controller;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.FinalProject.MaintenanceTracker.mapper.MaintenanceMapper;
import com.FinalProject.MaintenanceTracker.mapper.VehicleMapper;
import com.FinalProject.MaintenanceTracker.model.Maintenance;
import jakarta.servlet.http.HttpSession;
import com.FinalProject.MaintenanceTracker.model.Vehicle;
@Controller
public class MaintenanceController {


    private final MaintenanceMapper maintenanceMapper;
    private final VehicleMapper vehicleMapper;


    public MaintenanceController(MaintenanceMapper maintenanceMapper,
                                 VehicleMapper vehicleMapper) {

        this.maintenanceMapper = maintenanceMapper;
        this.vehicleMapper = vehicleMapper;
    }



    @GetMapping("/Maintenance")
    public String viewMaintenance(Model model, HttpSession session) {

        Integer userId = (Integer) session.getAttribute("userId");

        model.addAttribute(
            "maintenanceList",
            maintenanceMapper.findByUserId(userId)
        );

        return "Maintenance";
    }

    @GetMapping("/Maintenance/add")
    public String addMaintenancePage(Model model, HttpSession session) {

        Integer userId = (Integer) session.getAttribute("userId");

        List<Vehicle> vehicles = vehicleMapper.findByUserId(userId);

        model.addAttribute("vehicles", vehicles);
        model.addAttribute("maintenance", new Maintenance());

        return "addMaintenance";
    }
    @GetMapping("/Maintenance/delete/{id}")
    public String deleteMaintenance(@PathVariable("id") int id) {

        maintenanceMapper.deleteMaintenance(id);

        return "redirect:/Maintenance";
    }

    @PostMapping("/Maintenance/save")
    public String saveMaintenance(
            Maintenance maintenance,
            HttpSession session) {

        maintenanceMapper.insert(maintenance);

        return "redirect:/Maintenance";
    }
    
}