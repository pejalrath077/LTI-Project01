package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RequestForm;
import com.example.demo.service.RequestFormService;




@RestController

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
			@RequestParam(value = "Criticality", required = false) String criticality,
			@RequestParam(value = "Pending With", required = false) String pending,
			@RequestParam(value = "Verified By", required = false) String verifiedBy,
			@RequestParam(value = "Target Date", required = false) String target,
			@RequestParam(value = "Remark", required = false) String remark,
			@RequestParam(value = "Reported By", required = false) String reportedBy
			
			) {
		return service.createReq(system,issues,criticality,pending,verifiedBy,target,remark,reportedBy);
	}
	
	@DeleteMapping("/deleteIfulfill/{srNo}")
	public String deleteBySrNo(@PathVariable int srNo)
	{
		return service.deleteBySrNo(srNo);
		
	}
	@DeleteMapping("/deleteRemark/{srNo}")
	public RequestForm deleteRemak(@PathVariable int srNo)
	{
		return service.deleteRemak(srNo);
	}
	
	@PutMapping("/updateStatus")
	public RequestForm updateStatus(@RequestParam(value = "SrNo", required = true) int srNo,
			@RequestParam(value = "Status", required = true) String status)
	{
		return service.updateStatus(srNo,status);
	}
	
	@PutMapping("/assignTo")
	public RequestForm assignTo(@RequestParam(value = "SrNo", required = true) int srNo,
			@RequestParam(value = "Pending With", required = true) String pending)
	{
		return service.assignTo(srNo,pending);
	}
	
	@PutMapping("/updateRemark")
	public RequestForm updateRemark(
			@RequestParam(value = "SrNo", required = true) int srNo,
			@RequestParam(value = "Remark", required = false) String remark)
	{
		return service.updateRemark(srNo,remark);
	}

}
