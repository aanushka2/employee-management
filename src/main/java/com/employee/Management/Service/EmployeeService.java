package com.employee.Management.Service;

import java.util.List;

import com.employee.Management.Model.Employee;

public interface EmployeeService 
{
	List<Employee> getAllEmployee();
	
	void saveEmployee(Employee employee);
	
	Employee getEmployeeById(long id);
	
	void deleteEmployeeById( long id);
	

}
