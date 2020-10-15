package com.practice.hibernate.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "salesman")
public class Salesman {

	@Id
	@SequenceGenerator(initialValue = 101, name = "sg")
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sg")
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "commission")
	private double commission;
	
	@Column(name = "salesman_name")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
	@OneToMany
	private List<Customer> customers;

	public Salesman() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Salesman{" +
				"id=" + id +
				", commission=" + commission +
				", name='" + name + '\'' +
				", address=" + address +
				", customer=" + customers +
				'}';
	}
}
