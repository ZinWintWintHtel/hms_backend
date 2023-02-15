package com.hostmdy.hms.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.hms.domain.Service;

public interface ServiceService {
	
	Service saveOrUpdateService(Service service);
	
	List<Service> findAll();
	
	Optional<Service> findById(Long id);
	
	Optional<Service> findByPatientId(Long patientId);
	
	void deleteByPatientId(Long patientId);

}
