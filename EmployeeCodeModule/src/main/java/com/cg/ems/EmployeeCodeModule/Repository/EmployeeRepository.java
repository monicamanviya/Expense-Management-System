package com.cg.ems.EmployeeCodeModule.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.EmployeeCodeModule.Beans.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

}
