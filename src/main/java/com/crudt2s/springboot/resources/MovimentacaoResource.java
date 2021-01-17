package com.crudt2s.springboot.resources;

import java.util.ArrayList;
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
		List<Movimentacao> list = movimentacaoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<Movimentacao> findById(@PathVariable Integer id){
//		Movimentacao  movimentacao = movimentacaoService.findById(id);
//		return ResponseEntity.ok().body(movimentacao);
//	}
	
	@PostMapping
	public ResponseEntity<Movimentacao> insert(@RequestBody Movimentacao movimentacaoDTO){
		movimentacaoDTO =  movimentacaoService.insert(movimentacaoDTO);
		return ResponseEntity.ok().body(movimentacaoDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Movimentacao> update(@PathVariable Integer id, @RequestBody Movimentacao movimentacaoDTO){
		movimentacaoDTO =  movimentacaoService.update(id, movimentacaoDTO);
		return ResponseEntity.ok().body(movimentacaoDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		movimentacaoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/relatoriosImportacao")
	public ResponseEntity<List<Movimentacao>> relatorios(){
		List<Movimentacao> relatorios = movimentacaoService.geraRelatorioImportacao();
		return ResponseEntity.ok().body(relatorios);
	}
	
	@GetMapping(value = "/relatoriosExportacao")
	public ResponseEntity<List<Movimentacao>> relatoriosExportacao(){
		List<Movimentacao> relatorios = movimentacaoService.geraRelatorioExportacao();
		return ResponseEntity.ok().body(relatorios);
	}
	
	
	@GetMapping(value = "/relatorios")
	public ResponseEntity<List<Movimentacao>> teste(){
		List<Movimentacao> list = new ArrayList<>();
		List<Movimentacao> importacao = movimentacaoService.geraRelatorioImportacao();
		for(Movimentacao x: importacao) {
			list.add(x);
		}
		List<Movimentacao> exportacao = movimentacaoService.geraRelatorioExportacao();
		for(Movimentacao x: exportacao) {
			list.add(x);
		}
		return ResponseEntity.ok().body(list);
		
	}
	
}
