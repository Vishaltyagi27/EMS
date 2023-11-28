package com.ems.EMS.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.EMS.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	


	public List<Employee> findByDepartment(String department); 
	
	   List<Employee> findByDepartmentOrderByJoiningDateAsc(String department);
	    
	    List<Employee> findByDepartmentOrderByJoiningDateDesc(String department);

	    List<Employee> findAllByOrderByJoiningDateAsc();

	    List<Employee> findAllByOrderByJoiningDateDesc();
}
