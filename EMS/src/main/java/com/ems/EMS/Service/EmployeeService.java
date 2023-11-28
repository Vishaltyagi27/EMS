package com.ems.EMS.Service;

import java.util.List;

import com.ems.EMS.Entity.Employee;

public interface EmployeeService {

	
	    List<Employee> getAllEmployees();

	    Employee getEmployeeById(Long id);

	    Employee addEmployee(Employee employee);

	    Employee updateEmployee(Long id, Employee employee);

	    void deleteEmployee(Long id);
	      
		List<Employee>  findByDepartmentOrderByJoiningDateAsc(String department);
		List<Employee>  findByDepartmentOrderByJoiningDateDesc(String department);
		List<Employee>  findByDepartment(String department);
		List<Employee>  findAllByOrderByJoiningDateAsc();
		List<Employee>  findAllByOrderByJoiningDateDesc();
		List<Employee> findAll();
		
}
