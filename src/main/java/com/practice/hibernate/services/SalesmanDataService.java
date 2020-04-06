package com.practice.hibernate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.hibernate.beans.Salesman;
import com.practice.hibernate.repository.SalesmanRepository;

@Service
public class SalesmanDataService {

	@Autowired
	private SalesmanRepository repository;
	
	public void addSalesman(Salesman salesman) {
		
		repository.save(salesman);
		/*
		Salesman salesman = new Salesman(101, "Bittu");
		salesman.setCity("Hyderabad");
		salesman.setCommission(10452.33);
		*/
	}
	@Transactional
	public List<Salesman> getSalesmans() {
		return repository.findAll();
	}

}
