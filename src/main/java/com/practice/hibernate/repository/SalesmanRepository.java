package com.practice.hibernate.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.hibernate.beans.Salesman;

@Repository
public class SalesmanRepository {

	@Autowired
	private EntityManager entityManager;
	
	public <S extends Salesman> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends Salesman> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Salesman> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Salesman> findAll() {
		
		Session session = entityManager.unwrap(Session.class);
		Query<Salesman> query = session.createQuery("from Salesman", Salesman.class);
		return query.getResultList();
	}

	public Iterable<Salesman> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Salesman entity) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll(Iterable<? extends Salesman> entities) {
		// TODO Auto-generated method stub
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}