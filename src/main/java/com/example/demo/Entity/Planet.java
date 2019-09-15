package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "api_planet")
public class Planet extends Base {
	
	@Column(name="planet_name")
	private String name;
	
	@Column(name="planet_size")
	private double size;
	
	@ManyToOne
	@JoinColumn(name = "Star.id")
	private Star star;
	
	public Planet() {}
			
	public Planet(String name, double size, Star star) {
		this.name = name;
		this.size = size;
		this.star = star;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}
	
	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

}
