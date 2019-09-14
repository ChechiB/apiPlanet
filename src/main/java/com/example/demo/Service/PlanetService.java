package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.Entity.Planet;
import com.example.demo.Repository.PlanetRepository;

@Service
public class PlanetService {

	PlanetRepository planetRepository;

	public PlanetService(PlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}
	
	public PlanetDTO getOne(int id) {
		Optional<Planet> tmpPlanet = planetRepository.findById(id);
		PlanetDTO planetDTO = new PlanetDTO();
		
		try {
			Planet planet = tmpPlanet.get();
			planetDTO.setId(planet.getId());
			planetDTO.setName(planet.getName());
			return planetDTO;
		} catch (Exception e) {
			return planetDTO;
		}
	}
	
	public List<PlanetDTO> getAll(){
		List<PlanetDTO> planetsDTOs = new ArrayList<PlanetDTO>();
		
		for (Planet planet : planetRepository.findAll() ) {
			PlanetDTO planetDTO = new PlanetDTO();
			planetDTO.setId(planet.getId());
			planetDTO.setName(planet.getName());
			planetsDTOs.add(planetDTO);
		}
		
		return planetsDTOs;
	}
	
	public PlanetDTO post(PlanetDTO planetDTO) {
		Planet planet = new Planet();
		planet.setName(planetDTO.getName());
		try {
			planetRepository.save(planet);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		planetDTO.setId(planet.getId());
		return planetDTO;
	}
	
	public PlanetDTO put(PlanetDTO planetDTO, int id) {
		Optional<Planet> temp = planetRepository.findById(id);			
		try {		
			Planet planet = temp.get();
			planet.setName(planetDTO.getName());
			planetRepository.save(planet);		
			planetDTO.setId(planet.getId());		
		} catch (Exception e) {			
		}			
		return planetDTO;	
	}
	
	public boolean delete(int id) {
		Optional<Planet> temp = planetRepository.findById(id);	
		try {					
			planetRepository.delete(temp.get());
			return true;		
		} catch (Exception e) {
			return false;
			
		}
	}
	
}
