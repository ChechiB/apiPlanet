package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.DTO.StarDTO;
import com.example.demo.Entity.Star;
import com.example.demo.Repository.StarRepository;

@Service
public class StarService {
	StarRepository starRepository;

	public StarService(StarRepository starRepository) {
		this.starRepository = starRepository;
	}
	
	public StarDTO getOne(int id) {
		Optional<Star> tmpStar = starRepository.findById(id);
		StarDTO starDTO = new StarDTO();
		
		try {
			Star star = tmpStar.get();
			starDTO.setId(star.getId());
			starDTO.setName(star.getName());
			starDTO.setDensity(star.getDensity());
			return starDTO;
		} catch (Exception e) {
			return starDTO;
		}
	}
	
	public List<StarDTO> getAll(){
		List<StarDTO> starDTOs = new ArrayList<StarDTO>();
		
		for (Star star : starRepository.findAll() ) {
			StarDTO starDTO = new StarDTO();
			starDTO.setId(star.getId());
			starDTO.setName(star.getName());
			starDTO.setDensity(star.getDensity());
			starDTOs.add(starDTO);
		}
		
		return starDTOs;
	}
	
	public StarDTO post(StarDTO starDTO) {
		Star star = new Star();
		star.setName(starDTO.getName());
		star.setDensity(starDTO.getDensity());
		try {
			starRepository.save(star);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		starDTO.setId(star.getId());
		return starDTO;
	}
	
	public StarDTO put(StarDTO starDTO, int id) {
		Optional<Star> temp = starRepository.findById(id);			
		try {		
			Star star = temp.get();
			star.setName(starDTO.getName());
			star.setDensity(starDTO.getDensity());
			starRepository.save(star);		
			starDTO.setId(star.getId());		
		} catch (Exception e) {			
		}			
		return starDTO;	
	}
	
	public boolean delete(int id) {
		Optional<Star> temp = starRepository.findById(id);	
		try {					
			starRepository.delete(temp.get());
			return true;		
		} catch (Exception e) {
			return false;
			
		}
	}
	
}
