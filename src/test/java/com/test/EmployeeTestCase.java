package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Collection;

import org.junit.Test;

import com.model.emp.Developer;
import com.model.emp.Employee;
import com.model.emp.EmployeeId;
import com.model.emp.Manager;
import com.model.emp.QATester;

public class EmployeeTestCase {

	@Test
	public void qaTesterTestersWarrantAllocation() {
		BigDecimal expectedAllocation = new BigDecimal(500);
		EmployeeId employeeId = new EmployeeId();
		Employee employee = new QATester(employeeId);
		assertEquals(employee.getEmployeeId(), employeeId);
		assertTrue(employee instanceof QATester);
		assertEquals(expectedAllocation, employee.getExpenseAllocation());

	}

	@Test
	public void developersWarrantAllocation() {
		BigDecimal expectedAllocation = new BigDecimal(1000);
		EmployeeId employeeId = new EmployeeId();
		Employee employee = new Developer(employeeId);
		assertEquals(employee.getEmployeeId(), employeeId);
		assertTrue(employee instanceof Developer);
		assertEquals(expectedAllocation, employee.getExpenseAllocation());
	}

	@Test
	public void managerWarrantAllocation() {
		BigDecimal expectedAllocation = new BigDecimal(300);
		EmployeeId employeeId = new EmployeeId();
		Employee employee = new Manager(employeeId);
		assertEquals(employee.getEmployeeId(), employeeId);
		assertTrue(employee instanceof Manager);
		assertEquals(expectedAllocation, employee.getExpenseAllocation());

	}

	@Test
	public void managersCanHaveQATestersDeveloperManagerReports() {
		Employee irisManager = new Manager(new EmployeeId());
		Employee ryeDeveloper = new Developer(new EmployeeId());
		Employee bruceQATester = new QATester(new EmployeeId());
		Employee jtManager = new Manager(new EmployeeId());
		jtManager.addReport(irisManager);
		jtManager.addReport(ryeDeveloper);
		jtManager.addReport(bruceQATester);
		Collection<Employee> reports = jtManager.getReports();
		assertTrue(reports.contains(irisManager));
		assertTrue(reports.contains(ryeDeveloper));
		assertTrue(reports.contains(bruceQATester));

	}

	@Test(expected = IllegalStateException.class)
	public void qaTestersCannotHaveReports() {
		Employee bruceQATester = new QATester(new EmployeeId());
		Employee ryeDeveloper = new Developer(new EmployeeId());
		bruceQATester.addReport(ryeDeveloper);
	}

	@Test(expected = IllegalStateException.class)
	public void developersCannotHaveReports() {
		Employee ryeDeveloper = new Developer(new EmployeeId());
		Employee bruceQATester = new QATester(new EmployeeId());
		ryeDeveloper.addReport(bruceQATester);

	}

	@Test(expected = IllegalStateException.class)
	public void managerCannotManageThemself() {
		Employee irisManager = new Manager(new EmployeeId());
		irisManager.addReport(irisManager);

	}

}
