package com.FinalProject.MaintenanceTracker.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.FinalProject.MaintenanceTracker.model.User;

@Mapper
public interface UserMapper {

    List<User> findAll();

    User login(User user);

    void insert(User user);

}