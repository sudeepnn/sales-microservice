package com.sales.salesapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

import com.sales.salesapp.dao.SalesRecordRepository;
import com.sales.salesapp.dto.Salesrecorddto;
import com.sales.salesapp.entity.SalesRecord;

@Service
public class SalesRecordService {
	@Autowired
	SalesRecordRepository repository;
	
	public SalesRecord addRecord(Salesrecorddto salesrecord) {
		SalesRecord s=SalesRecord.builder()
				.id(salesrecord.getId())
				.manufacturecompany(salesrecord.getManufacturecompany())
				.model(salesrecord.getModel())
				.year(salesrecord.getYear())
				.color(salesrecord.getColor())
				.mileage(salesrecord.getMileage())
				.price(salesrecord.getPrice())
				.engineType(salesrecord.getEngineType())
				.transmission(salesrecord.getTransmission())
				.fuelEfficiency(salesrecord.getFuelEfficiency())
				.availablestatus(salesrecord.getAvailablestatus())
				.features(salesrecord.getFeatures())
				.manufactureddate(salesrecord.getManufactureddate())
				.discription(salesrecord.getDiscription())
				.wheeltype(salesrecord.getWheeltype())
				.airbags(salesrecord.getAirbags())
				.build();
		return repository.save(s);
	}
	
	public List<SalesRecord> getallRecordS(){
		return repository.findAll();
	}
	
	public SalesRecord getaRecord(long id) {
		Optional<SalesRecord> sales= repository.findById(id);
		if(sales.isPresent()) {
			return sales.get();
		}
		else {
			return null;
		}
	}
	
	public SalesRecord deletebyid(long id) {
		SalesRecord salesRecord=getaRecord(id);
		 repository.deleteById(id);
		 return salesRecord;
	}

	public Map<String, Long> getModelCounts() {
		List<SalesRecord> allRecords = repository.findAll();
		return allRecords.stream()
				.filter(record -> "Available".equalsIgnoreCase(record.getAvailablestatus()))
				.collect(Collectors.groupingBy(SalesRecord::getModel, Collectors.counting()));
	}
	
}
