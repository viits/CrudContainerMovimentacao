package com.crudt2s.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudt2s.springboot.entities.Movimentacao;
import com.crudt2s.springboot.services.MovimentacaoService;

@RestController
@RequestMapping(value = "/movimentacoes")
public class MovimentacaoResource {

	@Autowired
	private MovimentacaoService movimentacaoService;
	
	@GetMapping
	public ResponseEntity<List<Movimentacao>> findAll(){
		return ResponseEntity.ok().body(movimentacaoService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Movimentacao> findById(@PathVariable Integer id){
		Movimentacao  movimentacao = movimentacaoService.findById(id);
		return ResponseEntity.ok().body(movimentacao);
	}
	
	@PostMapping
	public ResponseEntity<Movimentacao> insert(@RequestBody Movimentacao movimentacao){
		movimentacao =  movimentacaoService.insert(movimentacao);
		return ResponseEntity.ok().body(movimentacao);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Movimentacao> update(@PathVariable Integer id, @RequestBody Movimentacao movimentacao){
		movimentacao =  movimentacaoService.update(id, movimentacao);
		return ResponseEntity.ok().body(movimentacao);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		movimentacaoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
