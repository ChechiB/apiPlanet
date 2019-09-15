package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.Entity.Planet;

public class StarDTO {
	private int id;	
	private String name;	
	private double density;
	private List<PlanetDTO> planets = new ArrayList();
	
	public StarDTO() {}
	
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
	public double getDensity() {
		return density;
	}
	public void setDensity(double density) {
		this.density = density;
	}

	public List<PlanetDTO> getPlanets() {
		return planets;
	}

	public void setPlanets(List<PlanetDTO> planets) {
		this.planets = planets;
	}
	
	
}
