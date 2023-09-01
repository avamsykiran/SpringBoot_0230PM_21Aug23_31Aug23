package com.cts.sbwd.services;

import org.springframework.stereotype.Service;

import com.cts.sbwd.models.Loan;

@Service
public class LoanServiceImpl implements LoanService {

	@Override
	public void computeInterest(Loan loan) {
		if(loan!=null) {
			loan.setSimpleInterest(loan.getLoanAmount()*loan.getTimePeriod()*loan.getRateOfInterest()/100.0);
		}
	}

}
