package com.model.emp;

import static com.common.CustomException.illegalStateException;
import java.math.BigDecimal;


public class QATester extends Employee {

	private static final BigDecimal EXPENSE_ALLOCATION = new BigDecimal(500);

	public QATester(EmployeeId employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public BigDecimal getExpenseAllocation() {
		return EXPENSE_ALLOCATION;
	}

	@Override
	public void addReport(Employee employee) {
		illegalStateException(employee, this);
	}


	@Override
	public EmployeeId getEmployeeId() {
		return employeeId;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + " [employeeId=" + employeeId + ", reports=" + reports
				+ "]";
	}

}
