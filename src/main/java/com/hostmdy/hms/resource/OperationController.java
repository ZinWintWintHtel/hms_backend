package com.hostmdy.hms.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.hms.domain.Operation;
import com.hostmdy.hms.service.OperationService;

@RestController
@RequestMapping("/api/operation")
@CrossOrigin(origins = "http://localhost:3000")
public class OperationController {
	private final OperationService operatioService;

	public OperationController(OperationService operatioService) {
		super();
		this.operatioService = operatioService;
	}

	@PostMapping("/create")
	public ResponseEntity<Operation> createOperation(@RequestBody Operation operation){
		Operation createdOperation = operatioService.saveOrUpdateOperation(operation);
		
		return new ResponseEntity<Operation>(createdOperation, HttpStatus.CREATED); 
	}
	
	@GetMapping("/all")
	public List<Operation> findAll(){
		List<Operation> operations = operatioService.findAll();
		
		return operations;
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Operation> operationOptional = operatioService.findById(id);
		
		if(operationOptional.isEmpty())
			return new ResponseEntity<String>("Operation with id = "+id+" is not found.",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Operation>(operationOptional.get(),HttpStatus.OK);
	}
	
	@GetMapping("/patientId/{patientId}")
	public ResponseEntity<?> findByPatientId(@PathVariable Long patientId){
		Optional<Operation> operationOptional = operatioService.findByPatientId(patientId);
		
		if(operationOptional.isEmpty())
			return new ResponseEntity<String>("Operation with patientId = "+patientId+" is not found.",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Operation>(operationOptional.get(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{patientId}")
	public ResponseEntity<Long> deleteByPatientId(@PathVariable Long patientId){
		operatioService.deleteByPatientId(patientId);
		
		return new ResponseEntity<Long>(patientId,HttpStatus.OK);
	}
	
	
}
