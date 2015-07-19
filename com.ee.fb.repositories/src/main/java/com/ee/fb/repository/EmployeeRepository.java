package com.ee.fb.repository;

import org.springframework.data.repository.CrudRepository;

import com.ee.domain.company.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String>{

}
