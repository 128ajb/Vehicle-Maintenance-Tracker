package com.FinalProject.MaintenanceTracker.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.FinalProject.MaintenanceTracker.model.Receipt;

@Mapper
public interface ReceiptMapper {

    List<Receipt> findAll();

	void insert(Receipt receipt);

}