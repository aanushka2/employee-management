package com.employee.Management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.Management.Model.Employee;
import com.employee.Management.Service.EmployeeService;



@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listEmployee", employeeService.getAllEmployee());
		return "index";
	}
	
	
	@GetMapping("/shownewEmployeeForm")
	public String showNewEmployee(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id,Model model)
	{
		//get employee from service
		Employee employee=this.employeeService.getEmployeeById(id);
		
		//set employee as model attribute tp pre-populate the form
		
		model.addAttribute("employee", employee);
		return "update_employee";		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(name = "id") long id)
	{
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
		
	}
}
