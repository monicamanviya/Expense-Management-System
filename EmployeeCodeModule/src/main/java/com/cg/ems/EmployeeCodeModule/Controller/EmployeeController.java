package com.cg.ems.EmployeeCodeModule.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.EmployeeCodeModule.Beans.Employee;
import com.cg.ems.EmployeeCodeModule.Exception.EmployeeNotFoundException;
import com.cg.ems.EmployeeCodeModule.Repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository repo;
	@PostMapping(value="/add")
	public Employee addStudent(@RequestBody Employee emp ) {
		return repo.save(emp);
		
	}
	@GetMapping("/all")
	//@CrossOrigin(origins = "http://localhost:4200")
	public List<Employee> getAllEmployee()
	{
		List<Employee>l = new ArrayList<Employee>();
		l=(List<Employee>) repo.findAll();
		
		return l;
	}
	
	@GetMapping("/{EmployeeId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Employee> getEmployeeById(@PathVariable("EmployeeId") int id)
	{
		List<Employee> list=new ArrayList<>();
		Optional<Employee> emp =repo.findById(id);
		if(emp.isPresent())
		{
			Employee emp1= emp.get();
			list.add(emp1);
			return list;
		}
		return list;
			
/*

		else
		{
			throw new EmployeeNotFoundException("Employee Id Not Found");
		}*/
	}
	@DeleteMapping("/{EmployeeId}")
	public void deleteStudentById(@PathVariable("EmployeeId") int id) {
		
		Optional<Employee> emp =repo.findById(id);
		if(emp.isPresent())
		
	repo.deleteById(id);
		else
		{
			throw new EmployeeNotFoundException("Employee Id Not Found");
		}
	}
	@PutMapping("/{id}")
	public String update(@RequestBody Employee emp, @PathVariable("id") int id) {
		
		emp.setEmployeeId(id);
		
		Optional<Employee> emp1 =repo.findById(id);
		if(emp1.isPresent())
		
	repo.save(emp);
		else
		{
			throw new EmployeeNotFoundException("Employee Id Not Found");
		}
		return "Record Updated Successfully";
	}
	
	

}
