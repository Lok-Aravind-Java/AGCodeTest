package com.test;

import com.model.emp.Developer;
import com.model.emp.Employee;
import com.model.emp.EmployeeId;
import com.model.emp.Manager;
import com.model.emp.QATester;


public class EmployeeUtil {

	public static Manager createManager() {
		return new Manager(new EmployeeId());
	}

	public static Developer createDeveloper() {
		return new Developer(new EmployeeId());
	}

	public static QATester createQATester() {
		return new QATester(new EmployeeId());
	}

	
	public static Employee createExampleScenario() {
		Employee managerA = new Manager(new EmployeeId());
		Employee managerB = new Manager(new EmployeeId());
		Employee developer = new Developer(new EmployeeId());
		Employee qatester = new QATester(new EmployeeId());

		managerB.addReport(developer);
		managerB.addReport(qatester);
		managerA.addReport(managerB);

		return managerA;
	}

	public static Manager createManagerWithReports(int developers,
			int qatesters) {
		Manager manager = createManager();
		for (int j = 0; j < developers; j++) {
			manager.addReport(createDeveloper());
		}
		for (int j = 0; j < qatesters; j++) {
			manager.addReport(createQATester());
		}
		return manager;
	}

}
