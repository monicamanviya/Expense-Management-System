package com.cg.ems.ProjectCodeModule.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.ems.ProjectCodeModule.bean.ProjectDetails;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectDetails,Integer>{

}
