package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.entity.RequestForm;
import com.example.demo.repository.RequestFormRepository;
//import com.example.demo.service.RequestFormService;

@RestController

public class RequestFormController {
	private static final Logger log = LoggerFactory.getLogger(RequestForm.class);

	// @Autowired
	// private RequestFormService service;

	@Autowired
	private RequestForm requestForm;

	@Autowired
	private List<RequestForm> requestFormList;

	@Autowired
	private RequestFormRepository requestFormRepository;

	@ApiIgnore
	@CrossOrigin
	@RequestMapping(value = "/")
	public void redirect(HttpServletResponse response) throws IOException {
		response.sendRedirect("/swagger-ui.html");
	}

	@CrossOrigin
	@PostMapping("/createRequestForm")
	public ResponseEntity<RequestForm> addRequestForm(@RequestParam(value = "Id", required = true) int id,
			@RequestParam(value = "System", required = false) String system,
			@RequestParam(value = "Issues", required = false) String issues,
			@RequestParam(value = "Criticality", required = false) String criticality,
			@RequestParam(value = "Pending With", required = false) String pending,
			@RequestParam(value = "Verified By", required = false) String verifiedBy,
			@RequestParam(value = "Target Date", required = false) String target,
			@RequestParam(value = "Remark", required = false) String remark,
			@RequestParam(value = "Reported By", required = false) String reportedBy) {
		RequestForm req = new RequestForm();
		req.setId(id);
		req.setSystem(system);
		req.setIssues(issues);
		req.setReportedDate();
		req.setCriticality(criticality);
		req.setPendingWith(pending);
		req.setStatus("Open");
		req.setVerifiedBy(verifiedBy);
		req.setTargetDate(target);
		req.setRemark(remark);
		req.setReportedBy(reportedBy);
		requestForm = requestFormRepository.save(req);
		log.info("Saved form=" + requestForm.toString());
		if (requestForm != null)
			return ResponseEntity.status(HttpStatus.CREATED).body(requestForm);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@CrossOrigin
	@PostMapping("/createRequestFormBrowser")
	public ResponseEntity<RequestForm> addRequestFormBrowser(@RequestBody RequestForm form) {
		requestForm = requestFormRepository.save(form);
		log.info("Saved quote=" + requestForm.toString());
		if (requestForm != null)
			return ResponseEntity.status(HttpStatus.CREATED).body(requestForm);

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@CrossOrigin
	@GetMapping("/getRequestForm")
	public ResponseEntity<List<RequestForm>> getAllRequestForms() {
		requestFormList = requestFormRepository.findAll();
		if (requestFormList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(requestFormList);
	}

	@CrossOrigin
	@GetMapping("/getRequestFormData")
	public List<RequestForm> getAllRequestFormsData() {
		requestFormList = requestFormRepository.findAll();
		return requestFormList;
	}

	@CrossOrigin
	@DeleteMapping("/delete={id}")
	public void deleteRequestForm(@PathVariable("id") String id) {
		this.requestFormRepository.deleteById(id);
	}

}
