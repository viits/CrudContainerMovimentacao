package com.crudt2s.springboot.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
}
