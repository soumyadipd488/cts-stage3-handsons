package com.cognizant.loans.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loans.model.Loan;

@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@GetMapping("/{number}")
	public Loan getLoanDetails(@PathVariable String number) {
		
		Loan loan = new Loan();
		loan.setNumber("H00987987972342");
		loan.setType("car");
		loan.setLoan(400000);
		loan.setEmi(3258);
		loan.setTenure(18);
		return loan;
	}
}
