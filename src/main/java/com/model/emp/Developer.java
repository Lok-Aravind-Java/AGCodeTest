package com.model.emp;


import java.math.BigDecimal;
import static com.common.CustomException.illegalStateException;

public class Developer extends Employee {

	private static final BigDecimal EXPENSE_ALLOCATION = new BigDecimal(1000);

	public Developer(EmployeeId employeeId) {
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
		return this.getClass().getName() + " [employeeId=" + employeeId
				+ ", reports=" + reports + "]";
	}

}
