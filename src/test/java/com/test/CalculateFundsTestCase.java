package com.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.common.CalculateFunds;
import com.model.dept.Department;
import com.model.emp.Employee;

public class CalculateFundsTestCase {

	@Test
	public void exampleScenario() {
		BigDecimal managerAsAllocation = new BigDecimal(2100);

		Employee managerA = EmployeeUtil.createExampleScenario();
		
		BigDecimal total = CalculateFunds.sumAllocations(managerA);
		//assert
		assertEquals(managerAsAllocation, total);
	}

	@Test
	public void sumRockStartDepartmentAllocations() {
		
		BigDecimal rockStarAllocation = new BigDecimal(12200);
		Department rockStar = DepartmentUtil.createRockStarDepartment();
		BigDecimal total = CalculateFunds.sumAllocations(rockStar);
		assertEquals(rockStarAllocation, total);
	}
	
	@Test
	public void sumOperationsDepartmentAllocations() {
		
		BigDecimal operationsAllocation = new BigDecimal(16200);
		Department operations = DepartmentUtil.createOperationsDepartment();
		BigDecimal total = CalculateFunds.sumAllocations(operations);
		assertEquals(operationsAllocation, total);
	}
	
	@Test
	public void sumOrganizationAllocations() {
		
		BigDecimal totalAllocation = new BigDecimal(28400);
		Department rockStar = DepartmentUtil.createRockStarDepartment();
		Department operations = DepartmentUtil.createOperationsDepartment();
		BigDecimal total = CalculateFunds.sumAllocations(rockStar);
		total = total.add(CalculateFunds.sumAllocations(operations));
		assertEquals(totalAllocation, total);
	}


}
