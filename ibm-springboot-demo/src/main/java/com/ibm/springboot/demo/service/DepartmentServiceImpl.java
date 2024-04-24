package com.ibm.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.demo.exception.DepartmentNotFoundException;
import com.ibm.springboot.demo.model.Department;
import com.ibm.springboot.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public List<Department> getAllDepartments() {
		LOG.info("getAllDepartments");

		List<Department> allDept = departmentRepository.findAll();
		if (allDept.isEmpty()) {
			String errorMessage = "Department collection is empty";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
		return allDept;
	}

	@Override
	public Department getDepartmentById(String departmentId) {
		LOG.info(departmentId);
		Optional<Department> deptOptional = departmentRepository.findById(departmentId);
		if (deptOptional.isEmpty()) {
			String errorMessage = "Department with id " + departmentId + " is not found!";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
		return deptOptional.get();
	}

	@Override
	public Department addDepartment(Department department) {
		LOG.info(department.toString());
		 List<Department> d =  departmentRepository.findByDepartmentName(department.getDepartmentName());
		if(!d.isEmpty())		{
			String errorMessage = "Department with id " + department.getDepartmentName() + " already exists!";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getDepartmentByName(String name) {
		LOG.info(name);
		List<Department> deptList = departmentRepository.findByDepartmentName(name);
		if (deptList.isEmpty()) {
			String errorMessage = "Department with name " + name + " is not found!";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
		return deptList;
	}

	@Override
	public Department updateDepartment(Department department) {
		LOG.info(department.toString());
		Department tempDepartment = getDepartmentById(department.getDepartmentId());

		if (department.getDepartmentName() != null)
			tempDepartment.setDepartmentName(department.getDepartmentName());

		if (department.getLocation() != null)
			tempDepartment.setLocation(department.getLocation());

		if (department.getManagerId() != null)
			tempDepartment.setManagerId(department.getManagerId());

		return departmentRepository.save(tempDepartment);
	}

	@Override
	public Department deleteDepartment(String departmentId) {
		LOG.info(departmentId);
		Department deptToBeDeleted = this.getDepartmentById(departmentId);
		departmentRepository.deleteById(departmentId);
		return deptToBeDeleted;
	}

}
