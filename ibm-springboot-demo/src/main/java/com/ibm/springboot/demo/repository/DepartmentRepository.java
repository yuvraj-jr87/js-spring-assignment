package com.ibm.springboot.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.springboot.demo.model.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String> {

	List<Department> findByDepartmentName(String name);
	
	Department findByManagerId(String magaerId);

	
	

}

