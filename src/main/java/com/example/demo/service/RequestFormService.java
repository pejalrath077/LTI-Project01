package com.example.demo.service;


import org.apache.commons.lang3.StringUtils;
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
	
	public String getHelloWorld()
	{
		return "Hello World!!!";
	}

	public Page<RequestForm> getIfulfills(Integer pagenumber, Integer limit,String keyword) {
		Pageable pageable=Pageable.unpaged();
		pagenumber =((null==pagenumber) ? 0:pagenumber-1);
		limit=((null==limit)?100000:limit);
		pageable=PageRequest.of(pagenumber, limit, Sort.by("sr_no").descending());
		keyword=(StringUtils.isBlank(keyword)?"%%":"%"+keyword+"%");
		return repository.findIfulfills(pageable,keyword);
	}

	public RequestForm createReq(String system, String issues, String criticality, String pending, String verifiedBy,
			String target, String remark, String reportedBy) {
		
		RequestForm req = new RequestForm();
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
		return repository.save(req);
			
	}
	@Transactional
	public String deleteBySrNo(int srNo) {
		repository.deleteBySrNo(srNo);
		
		return "Delete ID=" +srNo;
	}

	public RequestForm updateStatus(int srNo, String status) {
		
		RequestForm req=repository.findBySrNo(srNo).orElse(null);
		req.setSrNo(srNo);
		req.setStatus(status);
		return repository.save(req);
	}

	public RequestForm assignTo(int srNo, String pending) {
		RequestForm req=repository.findBySrNo(srNo).orElse(null);
		req.setSrNo(srNo);
		req.setPendingWith(pending);
		return repository.save(req);
	}

	public RequestForm updateRemark(int srNo, String remark) {
		RequestForm req=repository.findBySrNo(srNo).orElse(null);
		req.setSrNo(srNo);
		req.setRemark(remark);
		return repository.save(req);
	}

	public RequestForm deleteRemak(int srNo) {
		RequestForm req=repository.findBySrNo(srNo).orElse(null);
		req.setSrNo(srNo);
		req.setRemark(null);
		return repository.save(req);
	}
	
	

}
