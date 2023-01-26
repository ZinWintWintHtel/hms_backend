package com.hostmdy.hms.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Asset {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String assetName;
	private double price;
	private String category;
	private String description;
	private long patientIdentity;
	private String assetFees;
	private LocalDate startDate;
	private LocalDate endDate;
}
