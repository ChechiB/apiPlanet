package com.example.demo.DTO;

import java.io.Serializable;

public class StarSimpleDTO extends BaseDTO implements Serializable{
	private String name;	
	private double density;	
	
	public StarSimpleDTO() {}
	
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
