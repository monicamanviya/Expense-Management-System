package com.cg.ems.ExpenseCodeModule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.ems.ExpenseCodeModule.model.ExpenseCodeModule;

public interface ExpenseCodeModuleService {

	public List<ExpenseCodeModule> findAll();
	public Optional<ExpenseCodeModule> displayById(int id);
	public String update(ExpenseCodeModule expense);
	public String delete(int id);
	public String add(ExpenseCodeModule expense);
}
