package com.cts.sbwd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.sbwd.models.Loan;
import com.cts.sbwd.services.LoanService;

@Controller
@RequestMapping("/loan")
public class LoanController {

	@Autowired
	private LoanService loanService;

	@GetMapping
	public ModelAndView showLoanFormPageAction() {
		return new ModelAndView("loan-page","loan",new Loan());
	}
	
	@PostMapping
	public ModelAndView computeLoanFormPageAction(@ModelAttribute("loan") Loan loan) {
		loanService.computeInterest(loan);
		return new ModelAndView("loan-page","loan",loan);
	}
	
}
