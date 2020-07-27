package com.cg.ems.ProjectCodeModule.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ems.ProjectCodeModule.bean.ProjectDetails;
import com.cg.ems.ProjectCodeModule.repo.ProjectRepository;

@RequestMapping("/PLP")
@RestController
public class ProjectController {

	@Autowired
	private ProjectRepository repo;
	
	@PostMapping("/add")
	public String addProjectDetails(@RequestBody ProjectDetails projectDetails) {
		/*projectDetails.setBusinessUnti("DCX");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = "2019-10-01";
		try {
			projectDetails.setEndDate(sdf.parse(date));
			projectDetails.setStartDate(sdf.parse("2018-12-01"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		projectDetails.setProjectDesc("Third Project");*/
		repo.save(projectDetails);
		return "success";
		}
		
	@GetMapping("/displayAll")
	@CrossOrigin("http://localhost:4200")
	private List<ProjectDetails> displayAll(){
		return (List<ProjectDetails>) repo.findAll();
	}
		
	@GetMapping("/{id}")
	@CrossOrigin("http://localhost:4200")
	public List<ProjectDetails> displayById(@PathVariable("id") int code) {
		List<ProjectDetails> list= new ArrayList<>();
		ProjectDetails proj= repo.findById(code).get();
		list.add(proj);
		return list;
	}
	
	@PutMapping("/modify/{id}")
	public String modifyProjectDetails(@RequestBody ProjectDetails projectDetails,@PathVariable("id") int code) {
		projectDetails.setProjectCode(code);
		repo.save(projectDetails);
		return "Modified";
		}
	
//	@PutMapping("/customers/{id}")
//	public String update(@RequestBody Customer cust1, @PathVariable("id") long id) {
//		cust1.setId(id);
//		repo.save(cust1);
//		return "Uodated";
//	}
}
