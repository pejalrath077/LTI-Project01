package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RequestForm;
import com.example.demo.service.RequestFormService;



@RestController
//@RequestMapping("/api")
public class RequestFormController {
	@Autowired
	private RequestFormService service;

	@GetMapping("/getDemoDetails")
	public String getDemoDetails() {
		return service.getHelloWorld();
	}

	@GetMapping("/getIfulfills")
	public Page<RequestForm> getDemos(@RequestParam(value = "Pagenumber", required = false) Integer pagenumber,
			@RequestParam(value = "Limit", required = false) Integer limit,
			@RequestParam (value ="Keyword", required=false) String keyword) {
		return service.getIfulfills(pagenumber, limit,keyword);
	}

	// PostMapping
	@PostMapping("/createIfulfill")
	public RequestForm createReq(
			@RequestParam(value = "System", required = false) String system,
			@RequestParam(value = "Issues", required = false) String issues,
			@RequestParam(value = "Reported Date", required = false) String reportedDate,
			@RequestParam(value = "Criticality", required = false) String criticality,
			@RequestParam(value = "Pending With", required = false) String pending,
			@RequestParam(value = "Verified By", required = false) String verifiedBy,
			@RequestParam(value = "Target Date", required = false) String target,
			@RequestParam(value = "Remark", required = false) String remark,
			@RequestParam(value = "Reported By", required = false) String reportedBy
			
			) {
		return service.createReq(system,issues,reportedDate,criticality,pending,verifiedBy,target,remark,reportedBy);
	}
	
	@DeleteMapping("/deleteIfulfill/{id}")
	public String deleteBySrNo(@PathVariable int id)
	{
		return service.deleteBySrNo(id);
		
	}

}
