package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Demo;
import com.example.demo.service.DemoService;


@RestController
//@RequestMapping("/api")
public class DemoController {
	@Autowired
	private DemoService service;
	
	@GetMapping("/getDemoDetails")
	public String getDemoDetails()
	{
		return service.getHelloWorld();
	}
	
	@GetMapping("/getDemos")
	public Page<Demo> getDemos
	(	@RequestParam (value ="Pagenumber",required=false) Integer pagenumber,
		@RequestParam (value ="Limit", required=false) Integer limit
	)
	{
		return service.getDemos(pagenumber, limit);
	}

}
