package com.example.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Demo;
import com.example.demo.repository.DemoRepository;

@Service
public class DemoService {
	@Autowired
	private DemoRepository repository;
	
	public String getHelloWorld()
	{
		return "Hello World!!!";
	}

	public Page<Demo> getDemos(Integer pagenumber, Integer limit) {
		Pageable pageable=Pageable.unpaged();
		pagenumber =((null==pagenumber) ? 0:pagenumber-1);
		limit=((null==limit)?100000:limit);
		pageable=PageRequest.of(pagenumber, limit, Sort.by("show_id").descending());
		return repository.findDemo(pageable);
	}
	
	

}
