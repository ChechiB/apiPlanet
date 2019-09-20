package com.example.demo.DTO;

import java.io.Serializable;
import java.util.List;

public class PlanetDTO extends BaseDTO implements Serializable{

	
	private String name;
	private double size;
	private StarSimpleDTO star;
	
	public PlanetDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public StarSimpleDTO getStar() {
		return star;
	}

	public void setStar(StarSimpleDTO star) {
		this.star = star;
	}
	
	
}
