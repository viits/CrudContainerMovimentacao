package com.crudt2s.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudt2s.springboot.entities.Conteiner;
import com.crudt2s.springboot.services.ConteinerService;

@RestController
@RequestMapping(value = "/conteiners")
public class ConteinerResource {

	@Autowired
	private ConteinerService conteinerService;
	
	@GetMapping
	public ResponseEntity<List<Conteiner>> findAll(){
		return ResponseEntity.ok().body(conteinerService.findAll());
	}
	
}