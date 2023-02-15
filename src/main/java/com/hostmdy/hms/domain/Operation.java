package com.hostmdy.hms.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Operation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String operationName;
	private String operationType;
	private String operationFees;
	private String operationDescription;
	
	private Long patientId;
	private Long doctorId;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate operationDate;
	
	
	
	
}
