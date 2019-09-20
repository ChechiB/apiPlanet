package com.example.demo.Controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
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
import com.example.demo.DTO.StarDTO;
import com.example.demo.Service.StarService;

@Controller
@RestController
@RequestMapping(path = "api/v1/stars")
public class StarController {
	StarService starService;

	public StarController(StarService starService) {
		this.starService = starService;
	}
	
	//https://www.baeldung.com/spring-response-entity
	@GetMapping(path = "/{id}")
	@Transactional
	@CrossOrigin(origins = "*")	
	public ResponseEntity getOne(@PathVariable int id) {
		try {
			return ResponseEntity.status(200).body(starService.getOne(id));
		} catch (Exception e) {
			return ResponseEntity.status(404).body("No se encontro la estrella solicitada");
		}
	}
	
	@GetMapping(path = "/")
	@Transactional
	@CrossOrigin(origins = "*")	
	public ResponseEntity getAll(){
		try {
			return ResponseEntity.status(200).body(starService.getAll());
		} catch (Exception e) {
			return ResponseEntity.status(404).body("No se encontraron estrellas");
		}
	}
	
	@PostMapping(path = "/")
	@Transactional
	@CrossOrigin(origins = "*")	
	public ResponseEntity post(@RequestBody StarDTO starDTO) {
		StarDTO rst = new StarDTO();
		try {
			rst = starService.post(starDTO);
			return ResponseEntity.status(201).body(rst);
		} catch (Exception e) {
			return ResponseEntity.status(404).body("Solicitud no valida");
		}
	}
	
	@PutMapping(path = "/{id}")
	@Transactional
	@CrossOrigin(origins = "*")	
	public ResponseEntity put(@RequestBody StarDTO starDTO,@PathVariable int id) {
		StarDTO rst = new StarDTO();
		try {
			rst = starService.put(starDTO, id);
			return ResponseEntity.status(201).body(starDTO);
		} catch (Exception e) {
			return ResponseEntity.status(404).body("Solicitud no valida");
		}
		
	}
	
	@DeleteMapping(path = "/{id}")	
	@Transactional
	@CrossOrigin(origins = "*")	
	public ResponseEntity delete(@PathVariable int id) {
		try {
			starService.delete(id); 
			return ResponseEntity.status(204).body("");
		} catch (Exception e) {
			return ResponseEntity.status(404).body("No se pudo eliminar");
		}
	}
}
