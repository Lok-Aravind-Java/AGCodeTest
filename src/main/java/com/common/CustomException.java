package com.common;

import com.model.emp.Employee;

public class CustomException {
	public static void illegalStateException(Employee employee, Employee target) {
		throw new IllegalStateException("Cannot add "
				+ employee.getClass().getSimpleName() + " to "
				+ target.getClass().getSimpleName());
	}

}
