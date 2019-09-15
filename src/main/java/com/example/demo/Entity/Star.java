package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "api_star")
public class Star extends Base{
	
	@Column(name="star_name")
	private String name;
	
	@OneToMany(mappedBy = "star")
	private List<Planet> planets = new ArrayList();
	
	@Column(name="star_density")
	private double density;

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
