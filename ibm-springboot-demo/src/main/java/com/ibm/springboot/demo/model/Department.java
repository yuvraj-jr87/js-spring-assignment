package com.ibm.springboot.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("departments")
public class Department {

	@Id
	private String departmentId;
	private String departmentName;
	private String location;
	private String managerId;
	public Department(String departmentId, String departmentName, String location, String managerId) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.location = location;
		this.managerId = managerId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", location="
				+ location + ", managerId=" + managerId + "]";
	}

	

}
