package com.practice.hibernate.beans;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "state")
public class State {

    @Id
    @Column
    private int id;
    
    @Column
    private String name;
    
    @OneToMany
    private List<City> listOfCity;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "countryID")
    private Country country;

    public State() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    public List<City> getListOfCity() {
    	return listOfCity;
    }
    
    public void setListOfCity(List<City> listOfCity) {
    	this.listOfCity = listOfCity;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
