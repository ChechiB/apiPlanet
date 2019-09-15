package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.DTO.StarDTO;
import com.example.demo.Entity.Star;
import com.example.demo.Repository.StarRepository;

@Service
public class StarService {
	StarRepository starRepository;

	public StarService(StarRepository starRepository) {
		this.starRepository = starRepository;
	}
	
	public StarDTO getOne(int id) throws Exception{
		Optional<Star> tmpStar = starRepository.findById(id);
		
		try {
			Star star = tmpStar.get();
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper.map(star, StarDTO.class);
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public List<StarDTO> getAll() throws Exception{
		List<StarDTO> starDTOs = new ArrayList<StarDTO>();
		ModelMapper modelMapper = new ModelMapper();
		try {
			for (Star star : starRepository.findAll() ) {
				StarDTO starDTO = modelMapper.map(star, StarDTO.class);
				starDTOs.add(starDTO);
			}
			
			return starDTOs;
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public StarDTO post(StarDTO starDTO) throws Exception{
		ModelMapper modelMapper = new ModelMapper();
		try {
			Star star = modelMapper.map(starDTO, Star.class);
			//Por standar se devuelve un objeto
			star = starRepository.save(star);
			return modelMapper.map(star, StarDTO.class);
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	public StarDTO put(StarDTO starDTO, int id) throws Exception {
		Optional<Star> temp = starRepository.findById(id);		
		ModelMapper modelMapper = new ModelMapper();

		try {	
			Star star = temp.get();
			star = modelMapper.map(starDTO, Star.class);
			star = starRepository.save(star);		
			starDTO.setId(star.getId());		
			return modelMapper.map(star, StarDTO.class);			 
		} catch (Exception e) {			
			throw new Exception();
		}			
	}
	
	public boolean delete(int id) throws Exception {
		try {				
			if(starRepository.existsById(id)) {
				Optional<Star> temp = starRepository.findById(id);	
				starRepository.delete(temp.get());
				return true;
			}else {
				return false;
			}
					
		} catch (Exception e) {
			return false;
			
		}
	}
	
}
