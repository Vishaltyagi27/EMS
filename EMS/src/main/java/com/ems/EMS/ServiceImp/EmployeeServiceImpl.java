package com.ems.EMS.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.EMS.Entity.Employee;
import com.ems.EMS.Repo.EmployeeRepository;
import com.ems.EMS.Service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	    @Autowired
	    private EmployeeRepository employeeRepository;

	    @Override
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    @Override
	    public Employee getEmployeeById(Long id) {
	        return employeeRepository.findById(id).orElse(null);
	    }

	    @Override
	    public Employee addEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    @Override
	    public Employee updateEmployee(Long id, Employee employee) {
	        if (employeeRepository.existsById(id)) {
	            employee.setId(id);
	            return employeeRepository.save(employee);
	        }
	        return null;
	    }

	    @Override
	    public void deleteEmployee(Long id) {
	        employeeRepository.deleteById(id);
	    }
	
	   
	
	    @Override
	    public List<Employee>  findByDepartmentOrderByJoiningDateAsc(String department){
	    	
	    	return employeeRepository.findByDepartmentOrderByJoiningDateAsc(department);
	    }
	    
	    @Override
	  public List<Employee>  findByDepartmentOrderByJoiningDateDesc(String department){
		  
		  return employeeRepository.findByDepartmentOrderByJoiningDateDesc(department);
	  }
		
	    @Override
	  public List<Employee> findByDepartment(String department){
		  
		  return employeeRepository.findByDepartment(department);
	  }
	    
	    @Override
	  public List<Employee> findAllByOrderByJoiningDateAsc(){
		  
		  return employeeRepository.findAllByOrderByJoiningDateAsc();
	  }
	  
	    @Override
	  public List<Employee> findAllByOrderByJoiningDateDesc(){
		  
		  return employeeRepository.findAllByOrderByJoiningDateDesc();
	  }
	  
	    
	  public List<Employee> findAll(){
		  
		  return employeeRepository.findAll();
	  }
	  
}
