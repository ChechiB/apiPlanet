package com.example.demo.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name= "api_star")
public class Star extends Base implements Serializable{
	
	@Column(name="star_name", unique = true)
	@NotEmpty(message = "Name is mandatory")
	private String name;
	
	@Column(name="star_density")
	private double density;
	
	@OneToMany(mappedBy = "star",cascade = CascadeType.ALL)	
	private List<Planet> planets = new ArrayList();
	
	public List<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(List<Planet> planets) {
		this.planets = planets;
	}
	
	public Star() {}
	
	public Star(String name, double density) {
		this.name = name;
		this.density = density;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDensity() {
		return density;
	}

	public void setDensity(double density) {
		this.density = density;
	}
	
	

}
