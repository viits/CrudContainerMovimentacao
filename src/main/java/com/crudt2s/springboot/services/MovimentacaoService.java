package com.crudt2s.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudt2s.springboot.entities.Movimentacao;
import com.crudt2s.springboot.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	public List<Movimentacao> findAll(){
		return movimentacaoRepository.findAll();
	}
	
	public Movimentacao findById(Integer id) {
		Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);
		return movimentacao.get();
	}
	
	public Movimentacao insert(Movimentacao movimentacao) {
		return movimentacaoRepository.save(movimentacao);
	}
	
	public void delete(Integer id) {
		movimentacaoRepository.deleteById(id);
	}
	
	public Movimentacao update(Integer id, Movimentacao movimentacao) {
		Movimentacao entity = movimentacaoRepository.getOne(id);
		updateData(entity, movimentacao);
		return movimentacaoRepository.save(entity);
	}
	
	private void updateData(Movimentacao entity,Movimentacao movimentacao) {
		entity.setNameNavio(movimentacao.getNameNavio());
		entity.setTipoMovimentacao(movimentacao.getTipoMovimentacao());
		entity.setInicio(movimentacao.getInicio());
		entity.setFim(movimentacao.getFim());
	}
	
}
