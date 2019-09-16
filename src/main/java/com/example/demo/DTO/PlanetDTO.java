package com.example.demo.DTO;

import java.util.List;

public class PlanetDTO {

	private int id;
	private String name;
	private double size;
	private StarSimpleDTO star;
	
	public PlanetDTO() {
		
	}

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
