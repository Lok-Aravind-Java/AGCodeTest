package com.model.dept;

import com.model.emp.Manager;


public class Department {
	private final DepartmentId departmentId;

	private final Manager manager;

	public Department(DepartmentId departmentId, Manager manager) {
		this.departmentId = departmentId;
		this.manager = manager;
	}

	public Manager getManager() {
		return manager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((departmentId == null) ? 0 : departmentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (departmentId == null) {
			if (other.departmentId != null)
				return false;
		} else if (!departmentId.equals(other.departmentId))
			return false;
		return true;
	}

}
