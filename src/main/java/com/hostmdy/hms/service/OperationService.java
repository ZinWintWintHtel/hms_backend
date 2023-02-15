package com.hostmdy.hms.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.hms.domain.Operation;

public interface OperationService {

	Operation saveOrUpdateOperation(Operation operation);
	
	List<Operation> findAll();
	
	Optional<Operation> findById(Long id);
	
	Optional<Operation> findByPatientId(Long patientId);
	
	void deleteById(Long id);
	
	void deleteByPatientId(Long patientId);
}
