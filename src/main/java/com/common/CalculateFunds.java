package com.common;

import java.math.BigDecimal;

import com.model.dept.Department;
import com.model.emp.Employee;


public class CalculateFunds {


	public static BigDecimal sumAllocations(Employee employee) {
		BigDecimal total = employee.getExpenseAllocation();
		for (Employee directReport : employee.getReports()) {
			total = total.add(sumAllocations(directReport));
		}
		return total;
	}

	public static BigDecimal sumAllocations(Department department) {
		return sumAllocations(department.getManager());
	}

}
