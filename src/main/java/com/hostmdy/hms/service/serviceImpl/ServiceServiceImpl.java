package com.hostmdy.hms.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hostmdy.hms.domain.Service;
import com.hostmdy.hms.repository.ServiceRepository;
import com.hostmdy.hms.service.ServiceService;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService{

	private final ServiceRepository serviceRepository;
	
	@Autowired
	public ServiceServiceImpl(ServiceRepository serviceRepository) {
		super();
		this.serviceRepository = serviceRepository;
	}

	@Override
	public Service saveOrUpdateService(Service service) {
		// TODO Auto-generated method stub
		
		Optional<Service> serviceOpt = serviceRepository.findByPatientId(service.getPatientId());
		
		if(serviceOpt.isPresent())
			service.setId(serviceOpt.get().getId());
		
		return serviceRepository.save(service);
	}

	@Override
	public List<Service> findAll() {
		// TODO Auto-generated method stub
		return (List<Service>) serviceRepository.findAll();
	}

	@Override
	public Optional<Service> findById(Long id) {
		// TODO Auto-generated method stub
		return serviceRepository.findById(id);
	}

	@Override
	public Optional<Service> findByPatientId(Long patientId) {
		// TODO Auto-generated method stub
		return serviceRepository.findByPatientId(patientId);
	}

	@Override
	public void deleteByPatientId(Long patientId) {
		// TODO Auto-generated method stub
		Service service = serviceRepository.findByPatientId(patientId).get();
		
		serviceRepository.deleteById(service.getId());
	}



}
