package com.test;

import com.model.dept.Department;
import com.model.dept.DepartmentId;
import com.model.emp.Manager;



public class DepartmentUtil {
	
	public static Department createRockStarDepartment() {
		com.model.emp.Manager departmentHead = EmployeeUtil.createManager();
		
		Manager managera = EmployeeUtil.createManagerWithReports(4, 1);
		Manager managerb = EmployeeUtil.createManagerWithReports(2, 3);
		Manager managerc = EmployeeUtil.createManagerWithReports(1, 4);
		managera.addReport(managerb);
		departmentHead.addReport(managera);
		departmentHead.addReport(managerc);
		Department rockStar = new Department(new DepartmentId(), departmentHead);
		return rockStar;
	}
	
	
	public static Department createOperationsDepartment() {
		Manager departmentHead = EmployeeUtil.createManager();

		Manager managera = EmployeeUtil.createManager();
		Manager managerb = EmployeeUtil.createManager();
		Manager managerc = EmployeeUtil.createManagerWithReports(10, 10);

		departmentHead.addReport(managera);
		managera.addReport(managerb);
		managerb.addReport(managerc);

		Department operations = new Department(new DepartmentId(), departmentHead);
		return operations;
	}
	

}
