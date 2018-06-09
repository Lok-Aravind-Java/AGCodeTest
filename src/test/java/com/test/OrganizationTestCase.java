package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.model.dept.Department;
import com.model.dept.Organization;
import com.model.emp.Employee;

public class OrganizationTestCase {
	
	
	@Test
	public void departmentsConsistOfAnyKindsOfEmployees() {
		int numberOfEmployees = 43;
		Organization organization = new Organization();
		Department rockStart = DepartmentUtil.createRockStarDepartment();
		Department ops = DepartmentUtil.createOperationsDepartment();
		organization.add(rockStart);
		organization.add(ops);
		int totalEmployees = sumEmployees(organization);
		assertEquals(numberOfEmployees, totalEmployees);
		
	}

	private int sumEmployees(Organization organization) {
		int total = 0;
		for (Department depart : organization.getAllDepartments()) {
			total += sumEmployees(depart.getManager());
		}
		return total;
	}

	private int sumEmployees(Employee employee) {
		int total = 1;
		for (Employee directReport : employee.getReports()) {
			total = total + sumEmployees(directReport);
		}
		return total;
	}
	
}
