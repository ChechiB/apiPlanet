package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.Service.PlanetService;

@Controller
@RestController
@RequestMapping(path = "api/v1/planets")
public class PlanetController {

	PlanetService planetService;

	public PlanetController(PlanetService planetService) {
		this.planetService = planetService;
	}
	
	@GetMapping(path = "/{id}")
	public PlanetDTO getOne(@PathVariable int id) {
		return new PlanetDTO();
	}
	
	@GetMapping(path = "/")
	public List<PlanetDTO> getAll(){
		return ResponseEntity.status(200).body(planetService.getAll()).getBody();
	}
	
	@PostMapping(path = "/")
	public ResponseEntity post(@RequestBody PlanetDTO planetDTO) {
		PlanetDTO rst = new PlanetDTO();
		try {
			rst = planetService.post(planetDTO);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(201).body(rst);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity put(@RequestBody PlanetDTO planetDTO,@PathVariable int id) {
		PlanetDTO rst = new PlanetDTO();
		try {
			rst = planetService.put(planetDTO, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ResponseEntity.status(201).body(planetDTO);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		boolean rstEstado = planetService.delete(id); 
		if (rstEstado) {
			return ResponseEntity.status(204).body("");
		} else {
			return ResponseEntity.status(204).body("No funciona");
		}
	}
}
