package com.practice.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.hibernate.beans.Salesman;
import com.practice.hibernate.repository.SalesmanRepository;

@Service
public class SalesmanDataService {

	@Autowired
	private SalesmanRepository repository;
	
	public void addSalesman(Salesman salesman) {
		
		repository.save(salesman);
	}
	public void updateSalesman(Salesman salesman) {
		repository.saveAndFlush(salesman);
	}
	public Salesman getSalesman(int id) {
		return repository.findById(id).get();
	}
	public boolean deleteSalesMan(int id) {
		Salesman salesman = getSalesman(id);
		repository.delete(salesman);
		return true;
	}
	public boolean deleteAll() {
		repository.deleteAll();
		return true;
	}
	public List<Salesman> getSalesmen() {
		
		List<Salesman> salesmen = repository.findAll();
		if (salesmen == null) {
			salesmen = new ArrayList<>();
		}
		return salesmen;
	}

}
