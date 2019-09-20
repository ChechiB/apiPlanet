package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.DTO.StarDTO;
import com.example.demo.Entity.Star;
import com.example.demo.Repository.StarRepository;
import com.example.exception.StatusException;

@Service
public class StarService {
	StarRepository starRepository;

	public StarService(StarRepository starRepository) {
		this.starRepository = starRepository;
	}
	
	public StarDTO getOne(int id) throws StatusException{
		Optional<Star> tmpStar = starRepository.findById(id);
		
		try {
			Star star = tmpStar.get();
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(star, StarDTO.class);
		} catch (Exception e) {
			if(e.getClass().getCanonicalName().equals(NoSuchElementException.class.getCanonicalName())) {
				throw new StatusException("Star not found. Please check the id",404);
			}else {
				throw new StatusException("Bad request. Please check the values",404);
			}
		}
	}
	
	public List<StarDTO> getAll() throws StatusException{
		List<StarDTO> starDTOs = new ArrayList<StarDTO>();
		ModelMapper modelMapper = new ModelMapper();
		try {
			for (Star star : starRepository.findAll() ) {
				StarDTO starDTO = modelMapper.map(star, StarDTO.class);
				starDTOs.add(starDTO);
			}
			
			return starDTOs;
		} catch (Exception e) {
			throw new StatusException("Bad request. Please check the values",404);
			
		}
	}
	
	public StarDTO post(StarDTO starDTO) throws StatusException{
		ModelMapper modelMapper = new ModelMapper();
		try {
			Star star = modelMapper.map(starDTO, Star.class);
			//Por standar se devuelve un objeto
			star = starRepository.save(star);
			return modelMapper.map(star, StarDTO.class);
		}  catch (Exception e) {
			if(e.getClass().getCanonicalName().equals(DataIntegrityViolationException.class.getCanonicalName())) {
				throw new StatusException("Name must be unique",400);
			}else {
				throw new StatusException("Bad request. Please check the values",400);
			}
		}
		
	}
	
	public StarDTO put(StarDTO starDTO, int id) throws StatusException {
		Optional<Star> temp = starRepository.findById(id);		
		ModelMapper modelMapper = new ModelMapper();

		try {	
			Star stardb = temp.get();
			Star star = modelMapper.map(starDTO, Star.class);
			star.setId(stardb.getId());
			star = starRepository.save(star);		
			starDTO.setId(star.getId());		
			return modelMapper.map(star, StarDTO.class);			 
		} catch (Exception e) {
			if(e.getClass().getCanonicalName().equals(DataIntegrityViolationException.class.getCanonicalName())) {
				throw new StatusException("Name must be unique",400);
			}else {
				throw new StatusException("Bad request. Please check the values",400);
			}
		}			
	}

	public boolean delete(int id) throws StatusException {
		try {				
			if(starRepository.existsById(id)) {
				Optional<Star> temp = starRepository.findById(id);	
				starRepository.delete(temp.get());
				return true;
			}else {
				throw new Exception();
			}
					
		}catch (Exception e) {
			throw new StatusException("Bad request. Please verify the id",400);			
		}
	}
	
}
