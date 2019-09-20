package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.DTO.StarDTO;
import com.example.demo.Entity.Planet;
import com.example.demo.Entity.Star;
import com.example.demo.Repository.PlanetRepository;
import com.example.exception.StatusException;

@Service
public class PlanetService {

	PlanetRepository planetRepository;

	public PlanetService(PlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}
	
	
	public PlanetDTO getOne(int id) throws StatusException{
		Optional<Planet> tmpPlanet = planetRepository.findById(id);
		
		try {
			Planet planet = tmpPlanet.get();
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(planet, PlanetDTO.class);
		}  catch (Exception e) {
			if(e.getClass().getCanonicalName().equals(NoSuchElementException.class.getCanonicalName())) {
				throw new StatusException("Planet not found. Please check the id",404);
			}else {
				throw new StatusException("Bad request. Please check the values",404);
			}
		}
	}
	
	
	public List<PlanetDTO> getAll() throws StatusException{
		List<PlanetDTO> planetDTOs = new ArrayList<PlanetDTO>();
		ModelMapper modelMapper = new ModelMapper();
		try {
			for (Planet planet : planetRepository.findAll() ) {
				PlanetDTO planetDTO = modelMapper.map(planet, PlanetDTO.class);
				planetDTOs.add(planetDTO);
			}			
			return planetDTOs;
		} catch (Exception e) {
			throw new StatusException("Bad request. Please check the values",404);
			
		}
	}

	public PlanetDTO post(PlanetDTO planetDTO) throws StatusException{
		ModelMapper modelMapper = new ModelMapper();
		
		Planet planet = modelMapper.map(planetDTO, Planet.class);
		
		try {
			//Por estandar se devuelve un objeto
			planet = planetRepository.save(planet);
			return modelMapper.map(planet, PlanetDTO.class);
		}  catch (Exception e) {
			System.out.println("Excepcion 1: " + e);
			if(e.getClass().getCanonicalName().equals(DataIntegrityViolationException.class.getCanonicalName())) {
				throw new StatusException("Name must be unique",400);
			}else if((e.getClass().getCanonicalName().equals(InvalidDataAccessApiUsageException.class.getCanonicalName()))){
				throw new StatusException("Planet must has a Star",400);
			}else {
				throw new StatusException("Bad request. Please check the values",400);
			}
		}
			
		
	}

	public PlanetDTO put(PlanetDTO planetDTO, int id) throws StatusException {
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
			if(e.getClass().getCanonicalName().equals(DataIntegrityViolationException.class.getCanonicalName())) {
				throw new StatusException("Name must be unique",400);
			}else if(e.getClass().getCanonicalName().equals(InvalidDataAccessApiUsageException.class.getCanonicalName())){
				throw new StatusException("Planet must has a Star",400);
			}else {
				throw new StatusException("Bad request. Please check the values",400);
			}
		}			
	}
	
	public boolean delete(int id) throws StatusException {
		try {				
			if(planetRepository.existsById(id)) {
				Optional<Planet> temp = planetRepository.findById(id);	
				planetRepository.delete(temp.get());
				return true;
			}else {
				throw new Exception();
			}
					
		} catch (Exception e) {
			throw new StatusException("Bad request. Please verify the id",400);			
		}
	}
	
	
}
