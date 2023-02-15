package com.hostmdy.hms.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.hms.domain.Operation;

public interface OperationRepository extends CrudRepository<Operation, Long>{

	Optional<Operation> findByPatientId(Long patientId);
	
	void deleteByPatientId(Long patientId);
}
