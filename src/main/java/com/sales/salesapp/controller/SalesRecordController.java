package com.sales.salesapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sales.salesapp.dto.Salesrecorddto;
import com.sales.salesapp.entity.SalesRecord;
import com.sales.salesapp.service.SalesRecordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/cars")
public class SalesRecordController {
	
	@Autowired
	SalesRecordService service;

	@PostMapping
	public ResponseEntity<SalesRecord> addRecord(@RequestBody  Salesrecorddto salesrecord) {
	return new ResponseEntity<>(service.addRecord(salesrecord),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<SalesRecord>> getallRecords(){
		return new ResponseEntity<>(service.getallRecordS(),HttpStatus.OK);
	}
	@GetMapping("{id}")
	public ResponseEntity<SalesRecord> getaRecords(@PathVariable long id){
		return new ResponseEntity<>(service.getaRecord(id),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<SalesRecord> deleteRecord(@PathVariable long id){
		return new ResponseEntity<SalesRecord>(service.deletebyid(id),HttpStatus.OK);
	}
}
