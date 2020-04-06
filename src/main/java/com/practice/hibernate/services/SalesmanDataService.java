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
	public List<Salesman> getSalesmans() {
		List<Salesman> salesmen = repository.findAll();
		if (salesmen == null) {
			Salesman salesman = new Salesman(101, "Bittu");
			salesman.setCity("Hyderabad");
			salesman.setCommission(10452.33);
			salesmen = new ArrayList<>();
			salesmen.add(salesman);
		}
		return salesmen;
	}

}
