package com.test;

import com.model.dept.Organization;


public class OrganizationUtil {
	public static Organization createOrganization() {
		Organization organization = new Organization();
		organization.add(DepartmentUtil.createOperationsDepartment());
		organization.add(DepartmentUtil.createRockStarDepartment());
		return organization;
	}
}
