package com.practice.hibernate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

		return service.getSalesmen();
	}
	@PutMapping(value = "updateSalesman", consumes = "application/json")
	public void updateSalesman(@RequestBody Salesman salesman) {
		service.updateSalesman(salesman);
	}
	@PostMapping(value = "addNew")
	public void addNewSalesman(@RequestBody Salesman salesman) {
		service.addSalesman(salesman);
	}
	@GetMapping(value = "{id}")
	public Salesman getSalesman(@PathVariable int id) {
		return service.getSalesman(id);
	}
	@DeleteMapping(value = "delete/{id}")
	public boolean deleteSalesman(@PathVariable int id) {
		return service.deleteSalesMan(id);
	}
	@DeleteMapping(value = "delete")
	public boolean deleteAll() {
		return service.deleteAll();
	}
}
