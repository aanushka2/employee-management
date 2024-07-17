package com.employee.Management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Management.Model.Employee;
import com.employee.Management.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		
		return this.employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		
		Optional<Employee> optional=this.employeeRepository.findById(id);
		Employee employee=null;
		if(optional.isPresent())
		{
			employee=optional.get();
		}
		else
		{
			throw new RuntimeException("Employee Not found for id: "+id);
		}
		return employee;
		
		
	}

	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		this.employeeRepository.deleteById(id);
		
	}

}
