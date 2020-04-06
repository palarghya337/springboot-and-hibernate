package com.practice.hibernate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.hibernate.beans.Salesman;
import com.practice.hibernate.services.SalesmanDataService;

@RestController
public class SalesmanController {
	
	@Autowired
	private SalesmanDataService service;
	
	@GetMapping(path = "allSalesman")
	public List<Salesman> getSalesmans() {

		return service.getSalesmans();
		/*
		Configuration configuration = new Configuration();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(salesman);
		transaction.commit();
		*/
	}
}
