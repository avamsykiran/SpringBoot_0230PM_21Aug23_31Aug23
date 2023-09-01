package com.cts.sbwd.services;

import com.cts.sbwd.models.Loan;

public interface LoanService {
	void computeInterest(Loan loan);
}
