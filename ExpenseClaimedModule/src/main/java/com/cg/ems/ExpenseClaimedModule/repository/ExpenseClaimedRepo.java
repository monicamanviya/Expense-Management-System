package com.cg.ems.ExpenseClaimedModule.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.ExpenseClaimedModule.model.ExpenseClaimed;
@Repository
public interface ExpenseClaimedRepo extends CrudRepository<ExpenseClaimed, Integer>{

}
