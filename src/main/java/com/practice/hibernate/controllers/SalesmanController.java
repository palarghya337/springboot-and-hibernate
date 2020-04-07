package com.practice.hibernate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.hibernate.beans.Salesman;
import com.practice.hibernate.services.SalesmanDataService;

@RestController
@RequestMapping(value = "salesmen")
public class SalesmanController {
	
	@Autowired
	private SalesmanDataService service;
	
	@GetMapping(value = "all", produces = "application/json")
	public List<Salesman> getSalesmans() {

		return service.getSalesmans();
	}
	@PutMapping(value = "addNew", consumes = "application/json")
	public void addNewSalesman(@RequestBody Salesman salesman) {
		service.addSalesman(salesman);
	}
}
