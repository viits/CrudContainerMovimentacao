package com.crudt2s.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Conteiner> findById(@PathVariable Integer id){
		Conteiner conteiner = conteinerService.findById(id);
		return ResponseEntity.ok().body(conteiner);
	}
	
	@PostMapping
	public ResponseEntity<Conteiner> insert(@RequestBody Conteiner conteiner){
		 conteiner = conteinerService.insert(conteiner);
		 return ResponseEntity.ok().body(conteiner);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Conteiner> update(@PathVariable Integer id,@RequestBody Conteiner conteiner){
		conteiner = conteinerService.update(id, conteiner);
		return ResponseEntity.ok().body(conteiner);
	}
}
