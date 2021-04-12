package com.cognizant.loans.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
	private String number;
	private String type;
	private double loan;
	private double emi;
	private int tenure;
}
