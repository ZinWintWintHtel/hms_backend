package com.hostmdy.hms.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.hms.domain.Service;

public interface ServiceRepository extends CrudRepository<Service, Long>{
	
	Optional<Service> findByPatientId(Long patientId);
	
	void deleteByPatientId(Long patientId);
}
