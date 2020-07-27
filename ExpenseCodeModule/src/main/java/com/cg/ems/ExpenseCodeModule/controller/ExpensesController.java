package com.cg.ems.ExpenseCodeModule.controller;

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

import com.cg.ems.ExpenseCodeModule.exception.ExpenseDetailsNotFound;
import com.cg.ems.ExpenseCodeModule.model.ExpenseCodeModule;
import com.cg.ems.ExpenseCodeModule.service.ExpenseCodeModuleService;

@RestController
public class ExpensesController {

	@Autowired
	ExpenseCodeModule exp;

	@Autowired
	ExpenseCodeModuleService service;
	
	//display all
	@GetMapping("/expensecodemodule/")
	@CrossOrigin("http://localhost:4200")
	public List<ExpenseCodeModule> displayExpenses() {
		List<ExpenseCodeModule> list = service.findAll();
		if(list.isEmpty()) {
			throw new ExpenseDetailsNotFound("Expense Details not Found");
		}
		return list;
	}
	
	//display by id
	@GetMapping("/expensecodemodule/{id}")
	@CrossOrigin("http://localhost:4200")
	public List<ExpenseCodeModule> displayById(@PathVariable("id") int id) {
		List<ExpenseCodeModule> list = new ArrayList<ExpenseCodeModule>();
		Optional<ExpenseCodeModule> expense = service.displayById(id);
		if(expense.isPresent()) {
			list.add(expense.get());
			return list;
		}
		else
			//throw new ExpenseDetailsNotFound("Expenses of the ID: "+id+" not found!");
			return list;
	}

	//update details
	@PutMapping("/expensecodemodule/{id}")
	public String update(@RequestBody ExpenseCodeModule expense, @PathVariable("id") int id) {
		Optional<ExpenseCodeModule> expense1 = service.displayById(id);
		if(expense1.isPresent()) {
			expense.setExpense_code(id);
			return service.update(expense);
		}
		else {
			throw new ExpenseDetailsNotFound("Expenses of the ID: "+id+" not found!");
		}
	}
	
	//delete details
	@DeleteMapping("/expensecodemodule/{id}")
	public String delete(@PathVariable("id") int id) {
		Optional<ExpenseCodeModule> expense1 = service.displayById(id);
		if(expense1.isPresent()) {
			return service.delete(id);
		}
		else {
			throw new ExpenseDetailsNotFound("Expenses of the ID: "+id+" not found!");
	
		}
	}
	
	//add details
	@PostMapping("/expensecodemodule/")
	public String add(@RequestBody ExpenseCodeModule expense) {
		return service.add(expense);
	}
	

	
}
