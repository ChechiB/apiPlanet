package com.example.demo.Controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.Entity.Star;
import com.example.demo.Service.PlanetService;
import com.example.demo.Service.StarService;
import com.example.exception.StatusException;

@Controller
@RestController
@RequestMapping(path = "api/v1/planets")
public class PlanetController {

	PlanetService planetService;

	public PlanetController(PlanetService planetService) {
		this.planetService = planetService;
	}
	
	@GetMapping(path = "/{id}")
	
	@CrossOrigin(origins = "*")	
	public ResponseEntity getOne(@PathVariable int id) {
		try {
			return ResponseEntity.status(200).body(planetService.getOne(id));
		} catch (Exception e) {
			return ResponseEntity.status(404).body("No se encontro el Planeta solicitado");
		}
	}
	
	@GetMapping(path = "/")
	
	@CrossOrigin(origins = "*")	
	public ResponseEntity getAll(){
		try {
			return ResponseEntity.status(200).body(planetService.getAll());
		} catch (Exception e) {
			return ResponseEntity.status(404).body("No se encontraron planetas");
		}
	}
	
	@PostMapping(path = "/")
	
	@CrossOrigin(origins = "*")	
	public ResponseEntity post(@RequestBody PlanetDTO planetDTO) {
		PlanetDTO rst = new PlanetDTO();
		try {
			
			return ResponseEntity.status(201).body(planetService.post(planetDTO));
		
		} catch (StatusException e) {
			
			return e.getResponseStatus();
		}catch(Exception e) {
			return null;
		}
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity put(@RequestBody PlanetDTO planetDTO,@PathVariable int id) {
		PlanetDTO rst = new PlanetDTO();
		try {
			rst = planetService.put(planetDTO, id);
			return ResponseEntity.status(201).body(planetDTO);
		} catch (Exception e) {
			return ResponseEntity.status(400).body("Solicitud no valida");
		}		
	}
	
	@DeleteMapping(path = "/{id}")	
	public ResponseEntity delete(@PathVariable int id) {
		boolean rstEstado;
		try {
			planetService.delete(id);
			return ResponseEntity.status(204).body("");
		} catch (Exception e) {
			return ResponseEntity.status(404).body("No se pudo eliminar");
		} 
		
	}
}
