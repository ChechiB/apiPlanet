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
import com.example.demo.DTO.StarDTO;
import com.example.demo.Service.StarService;

@Controller
@RestController
@RequestMapping(path = "api/v1/planets")
public class StarController {
	StarService starService;

	public StarController(StarService starService) {
		super();
		this.starService = starService;
	}
	
	@GetMapping(path = "/{id}")
	public StarDTO getOne(@PathVariable int id) {
		return new StarDTO();
	}
	
	@GetMapping(path = "/")
	public List<StarDTO> getAll(){
		return ResponseEntity.status(200).body(starService.getAll()).getBody();
	}
	
	@PostMapping(path = "/")
	public ResponseEntity post(@RequestBody StarDTO starDTO) {
		StarDTO rst = new StarDTO();
		try {
			rst = starService.post(starDTO);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ResponseEntity.status(201).body(rst);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity put(@RequestBody StarDTO starDTO,@PathVariable int id) {
		StarDTO rst = new StarDTO();
		try {
			rst = starService.put(starDTO, id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ResponseEntity.status(201).body(starDTO);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		boolean rstEstado = starService.delete(id); 
		if (rstEstado) {
			return ResponseEntity.status(204).body("");
		} else {
			return ResponseEntity.status(204).body("No funciona");
		}
	}
}
