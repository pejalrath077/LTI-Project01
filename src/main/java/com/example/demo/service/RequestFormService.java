package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.RequestForm;
import com.example.demo.repository.RequestFormRepository;

@Service
public class RequestFormService {
	@Autowired
	private RequestFormRepository repository;

	public String getHelloWorld() {
		return "Hello World!!!";
	}

	// public Page<RequestForm> getIfulfills(Integer pagenumber, Integer limit) {
	// Pageable pageable = Pageable.unpaged();
	// pagenumber = ((null == pagenumber) ? 0 : pagenumber - 1);
	// limit = ((null == limit) ? 100000 : limit);
	// pageable = PageRequest.of(pagenumber, limit, Sort.by("id").descending());
	// return repository.findIfulfills(pageable);
	// }

	// public RequestForm createReq(String system, String issues, String
	// reportedDate, String criticality, String pending,
	// String verifiedBy, String target, String remark, String reportedBy) {

	// RequestForm req = new RequestForm();
	// req.setSystem(system);
	// req.setIssues(issues);
	// req.setReportedDate(reportedDate);
	// req.setCriticality(criticality);
	// req.setPendingWith(pending);
	// req.setStatus("Open");
	// req.setVerifiedBy(verifiedBy);
	// req.setTargetDate(target);
	// req.setRemark(remark);
	// req.setReportedBy(reportedBy);
	// return repository.save(req);

	// }

}
