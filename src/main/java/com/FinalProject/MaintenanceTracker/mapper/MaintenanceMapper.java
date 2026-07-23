package com.FinalProject.MaintenanceTracker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.FinalProject.MaintenanceTracker.model.Maintenance;

@Mapper
public interface MaintenanceMapper {

    List<Maintenance> findByUserId(Integer userId);

    void insert(Maintenance maintenance);

	void deleteMaintenance(int id);

}