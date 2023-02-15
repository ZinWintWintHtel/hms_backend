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
public class Service {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long doctorId;
	private Long patientId;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate serviceDate;
	
	private String doctorFees;
	private String medicineFees;
	private String nursingFees;
	private String assetFees;
	private String operationFees;
	private String checkupFees;
	private String serviceAmount;
	
	
}
