package com.cg.ems.ExpenseCodeModule.repository;

import org.springframework.data.repository.CrudRepository;

import com.cg.ems.ExpenseCodeModule.model.ExpenseCodeModule;

public interface ExpensesDao extends CrudRepository<ExpenseCodeModule, Integer>{

}
