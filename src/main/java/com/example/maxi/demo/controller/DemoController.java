package com.example.maxi.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.maxi.demo.model.Persona;

@RestController
public class DemoController {
	
	@GetMapping("/personas")
	public List<Persona> obtenerPersonas() {
		List<Persona> personas = new ArrayList<Persona>();
		personas.add(new Persona(1l, "Perosna 1", "Apellido 1", 30000000, "DNI"));
		personas.add(new Persona(2l, "Perosna 2", "Apellido 2", 40000000, "P"));
		return personas;
	}

}
