package com.practice.hibernate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.hibernate.beans.Country;
import com.practice.hibernate.repository.CountryRepository;

@Service
public class CountryDataService {

	@Autowired
	private CountryRepository repository;
	
	public List<Country> getAllCountries() {
		return repository.findAll();
	}

	public Country getCountry(int id) {
		
		Optional<Country> countryOptional = repository.findById(id);
		if (countryOptional.isPresent()) {
			return countryOptional.get();
		}
		return null;
	}

	public Country addCountry(Country country) {
		return repository.save(country);
	}

	public Country updateCountryData(Country country) {
		return repository.saveAndFlush(country);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public void delete(int id) {
		repository.deleteById(id);
	}

}
