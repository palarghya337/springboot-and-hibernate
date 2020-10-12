package com.practice.hibernate.beans;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String name;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stateID")
    private State state;

    public City() {}

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

    public State getState() {
    	return state;
    }
    
    public void setState(State state) {
    	this.state = state;
    }
    
    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
