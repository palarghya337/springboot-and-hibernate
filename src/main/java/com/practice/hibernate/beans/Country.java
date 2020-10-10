package com.practice.hibernate.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @SequenceGenerator(initialValue = 101, name = "sg")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sg")
    @Column
    private int id;
    @Column
    private String name;
    @OneToMany
    private List<State> states;

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

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", states=" + states +
                '}';
    }
}
