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

import com.hostmdy.hms.domain.Service;
import com.hostmdy.hms.service.ServiceService;


@RestController
@RequestMapping("/api/service")
@CrossOrigin(origins = "http://localhost:3000")
public class ServiceController {
	
	private final ServiceService serviceService;

	public ServiceController(ServiceService serviceService) {
		super();
		this.serviceService = serviceService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Service> createService(@RequestBody Service service){
		Service createdService = serviceService.saveOrUpdateService(service);
		
		return new ResponseEntity<Service>(createdService,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Service> findAll(){
		List<Service> services = serviceService.findAll();
		
		return services;
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Service> serviceOptional = serviceService.findById(id);
		
		if(serviceOptional.isEmpty())
			return new ResponseEntity<String>("Service with id = "+id+" is not found.",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Service>(serviceOptional.get(),HttpStatus.OK);
	}
	
	
	@GetMapping("/patientId/{patientId}")
	public ResponseEntity<?> findBypatientId(@PathVariable Long patientId){
		Optional<Service> serviceOptional = serviceService.findByPatientId(patientId);
		
		if(serviceOptional.isEmpty())
			return new ResponseEntity<String>("Service with patientId"+patientId+" is not found.",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Service>(serviceOptional.get(),HttpStatus.OK);
	
	}
	
	@DeleteMapping("/delete/{patientId}")
	public ResponseEntity<Long> deleteByPatientId(@PathVariable Long patientId){
		serviceService.deleteByPatientId(patientId);
		
		return new ResponseEntity<Long>(patientId,HttpStatus.OK);

	}

}
