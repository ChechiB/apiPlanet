package com.example.demo.DTO;

import java.io.Serializable;

public class PlanetSimpleDTO extends BaseDTO implements Serializable{

	private String name;
	private double size;
	
	public PlanetSimpleDTO() {
		
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

}
