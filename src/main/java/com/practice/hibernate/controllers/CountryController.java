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

import com.practice.hibernate.beans.Country;
import com.practice.hibernate.services.CountryDataService;

@RestController
@RequestMapping(value = "countryService")
public class CountryController {
	
	@Autowired
	private CountryDataService service;
	
	public CountryController() {
	}
	
	@GetMapping(value = "getAllCountries")
	public List<Country> getAllCountries() {
		return service.getAllCountries();
	}
	
	@GetMapping(value = "getCountry({countryID}")
	public Country getCountry(@PathVariable(name = "countryID") int id) {
		return service.getCountry(id);
	}
	
	@PostMapping(value = "addCountry")
	public Country addCountry(@RequestBody Country country) {
		return service.addCountry(country);
	}
	
	@PutMapping(value = "updateCountryData")
	public Country updateCountryData(@RequestBody Country country) {
		return service.updateCountryData(country);
	}
	
	@DeleteMapping(value = "deleteAllCountries")
	public void deleteAll() {
		service.deleteAll();
	}
	
	@DeleteMapping(value = "deleteCountry({countryID}")
	public void delete(@PathVariable(name = "countryID") int id) {
		service.delete(id);
	}

}
