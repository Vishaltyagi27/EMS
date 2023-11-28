package com.ems.EMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ems.EMS.Entity.Employee;
import com.ems.EMS.Service.EmployeeService;


import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	    @Autowired
	    private EmployeeService employeeService;

	    @GetMapping
	    public List<Employee> getAllEmployees( @RequestParam(required = false, defaultValue = "NA") String department,
	    		@RequestParam(required = false, defaultValue = "asc") String sort) {
	    	
	    	List<Employee> employees;

	    	
	    	  if (!department.equalsIgnoreCase("NA")) {
	    	        if ("asc".equalsIgnoreCase(sort)) {
	    	            employees = employeeService.findByDepartmentOrderByJoiningDateAsc(department);
	    	        } else if ("desc".equalsIgnoreCase(sort)) {
	    	            employees = employeeService.findByDepartmentOrderByJoiningDateDesc(department);
	    	        } else {
	    	            employees = employeeService.findByDepartment(department);
	    	        }
	    	    } else {
	    	        if ("asc".equalsIgnoreCase(sort)) {
	    	            employees = employeeService.findAllByOrderByJoiningDateAsc();
	    	        } else if ("desc".equalsIgnoreCase(sort)) {
	    	            employees = employeeService.findAllByOrderByJoiningDateDesc();
	    	        } else {
	    	            employees = employeeService.findAll();
	    	        }
	    	    }

	    	    return employees;
	    }

	    @GetMapping("/{id}")
	    public Employee getEmployeeById(@PathVariable Long id) {
	        return employeeService.getEmployeeById(id);
	    }

	    @PostMapping
	    public Employee addEmployee( @RequestBody Employee employee) {
	        return employeeService.addEmployee(employee);
	    }

	    @PutMapping("/{id}")
	    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
	        return employeeService.updateEmployee(id, employee);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	    }
	}

