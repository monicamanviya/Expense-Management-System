package com.cg.ems.ExpenseClaimedModule.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.ExpenseClaimedModule.model.ExpenseClaimed;
import com.cg.ems.ExpenseClaimedModule.repository.ExpenseClaimedRepo;

@RestController
public class ExpenseClaimedController {
	@Autowired
	ExpenseClaimedRepo repo;
	
	@PostMapping(value="/add")
	public ExpenseClaimed add(@RequestBody ExpenseClaimed expense ) {
		return repo.save(expense);
		
	}
	
	@GetMapping("/view/{expenseCode}")
	public Optional<ExpenseClaimed> view(@PathVariable ("expenseCode") int expenseCode){
		System.out.println(repo.findById(expenseCode));
		System.out.println("hi");
		return repo.findById(expenseCode);
	}
	
	@DeleteMapping("/delete/{expenseCode}")
	public String delete(@PathVariable ("expenseCode") int expenseCode){
		if(repo.findById(expenseCode)!=null) {
		repo.deleteById(expenseCode);
	
		return "deleted";
		}
		return "cannot be deleted";
	}
	
	@PutMapping("/update/{expenseCode}")
	public String update(@RequestBody ExpenseClaimed expense, @PathVariable ("expenseCode") int expenseCode){
		if(repo.findById(expenseCode)!=null) {
			repo.save(expense);
		
			return "updated";
			}
		return "cannot be updated";
	}
	

}
