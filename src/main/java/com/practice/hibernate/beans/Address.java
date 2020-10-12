package com.practice.hibernate.beans;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private int zipCode;
    @Column
    private String addressLine;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cityID")
    private City city;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stateID")
    private State state;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "countryID")
    private Country country;

    public Address() {}

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipCode=" + zipCode +
                ", addressLine='" + addressLine + '\'' +
                ", city=" + city +
                ", state=" + state +
                ", country=" + country +
                '}';
    }
}
