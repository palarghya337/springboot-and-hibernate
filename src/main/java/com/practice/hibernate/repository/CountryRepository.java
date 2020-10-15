package com.practice.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.hibernate.beans.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
