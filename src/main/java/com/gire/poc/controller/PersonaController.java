package com.gire.poc.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gire.poc.model.Persona;
import com.gire.poc.repository.PersonaRepository;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	PersonaRepository personaRepository;
	
	@GetMapping
	public List<Persona> obtenerPersonas() {
		return personaRepository.findAll();
	}
	
	@PostMapping
	public Persona crearPersona(@Validated @RequestBody Persona persona) {
		return personaRepository.save(persona);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizarPersona(@PathVariable String id, @RequestBody Persona persona) {
		if(!id.equals(persona.getId())) {
			Map<String, Object> errorBody = new LinkedHashMap<String, Object>();
			errorBody.put("message", "te mandaste alguna");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
		}
		Persona personaActualizada = personaRepository.save(persona);
		return new ResponseEntity<Persona>(personaActualizada, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void borrarPersona(@PathVariable String id) {
		personaRepository.deleteById(id);
	}

}
