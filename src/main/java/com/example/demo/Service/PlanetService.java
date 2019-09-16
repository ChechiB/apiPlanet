package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.DTO.StarDTO;
import com.example.demo.Entity.Planet;
import com.example.demo.Entity.Star;
import com.example.demo.Repository.PlanetRepository;

@Service
public class PlanetService {

	PlanetRepository planetRepository;

	public PlanetService(PlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}
	
	
	public PlanetDTO getOne(int id) throws Exception{
		Optional<Planet> tmpPlanet = planetRepository.findById(id);
		
		try {
			Planet planet = tmpPlanet.get();
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(planet, PlanetDTO.class);
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	
	public List<PlanetDTO> getAll() throws Exception{
		List<PlanetDTO> planetDTOs = new ArrayList<PlanetDTO>();
		ModelMapper modelMapper = new ModelMapper();
		try {
			for (Planet planet : planetRepository.findAll() ) {
				PlanetDTO planetDTO = modelMapper.map(planet, PlanetDTO.class);
				planetDTOs.add(planetDTO);
			}
			
			return planetDTOs;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	public PlanetDTO post(PlanetDTO planetDTO) throws Exception{
		ModelMapper modelMapper = new ModelMapper();
		try {
			Planet planet = modelMapper.map(planetDTO, Planet.class);
			System.out.print("star:"+ planet.getStar().getId());
			//Por standar se devuelve un objeto
			planet = planetRepository.save(planet);
			return modelMapper.map(planet, PlanetDTO.class);
		} catch (Exception e) {
			System.out.print("Exception:" +e);
			throw new Exception();
		}
		
	}

	public PlanetDTO put(PlanetDTO planetDTO, int id) throws Exception {
		Optional<Planet> temp = planetRepository.findById(id);		
		ModelMapper modelMapper = new ModelMapper();

		try {	
			Planet planetdb = temp.get();
			Planet planet = modelMapper.map(planetDTO, Planet.class);
			planet.setId(planetdb.getId());
			planet = planetRepository.save(planet);		
			planetDTO.setId(planet.getId());		
			return modelMapper.map(planet, PlanetDTO.class);			 
		} catch (Exception e) {			
			throw new Exception();
		}			
	}
	
	public boolean delete(int id) throws Exception {
		try {				
			if(planetRepository.existsById(id)) {
				Optional<Planet> temp = planetRepository.findById(id);	
				planetRepository.delete(temp.get());
				return true;
			}else {
				throw new Exception();
			}
					
		} catch (Exception e) {
			throw new Exception();
			
		}
	}
	
	
}
