package com.example.demo.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "api_planet")
public class Planet extends Base implements Serializable {
	
	@Column(name="planet_name")
	private String name;
	
	@Column(name="planet_size")
	private double size;
	
	@ManyToOne(fetch = FetchType.LAZY)
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
