package com.hostmdy.hms.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.hms.domain.Operation;
import com.hostmdy.hms.repository.OperationRepository;
import com.hostmdy.hms.service.OperationService;

@Service
public class OperationServiceImpl implements OperationService{

	
	private final OperationRepository operationRepository;
	
	@Autowired
	public OperationServiceImpl(OperationRepository operationRepository) {
		super();
		this.operationRepository = operationRepository;
	}


	@Override
	public Operation saveOrUpdateOperation(Operation operation) {
		// TODO Auto-generated method stub
		
		Optional<Operation> operationOpt = operationRepository.findByPatientId(operation.getPatientId());
		
		if(operationOpt.isPresent())
			operation.setId(operationOpt.get().getId());
		
		return operationRepository.save(operation);
	}


	@Override
	public List<Operation> findAll() {
		// TODO Auto-generated method stub
		return (List<Operation>) operationRepository.findAll();
	}


	@Override
	public Optional<Operation> findById(Long id) {
		// TODO Auto-generated method stub
		return operationRepository.findById(id);
	}


	@Override
	public Optional<Operation> findByPatientId(Long patientId) {
		// TODO Auto-generated method stub
		
		return operationRepository.findByPatientId(patientId);
	}


	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteByPatientId(Long patientId) {
		// TODO Auto-generated method stub
		Operation operation = operationRepository.findByPatientId(patientId).get();
		
		operationRepository.deleteById(operation.getId());
	}



}
