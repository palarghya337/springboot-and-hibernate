package com.practice.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.hibernate.beans.Salesman;

@Repository
public interface SalesmanRepository
		extends JpaRepository<Salesman, Integer> {
	
}