package com.crudt2s.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crudt2s.springboot.entities.Movimentacao;
import com.crudt2s.springboot.exceptions.DBException;
import com.crudt2s.springboot.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository movimentacaoRepository;

	@Transactional(readOnly = true)
	public List<Movimentacao> findAll() {
		List<Movimentacao> list = movimentacaoRepository.findAll();
		return list;
	}

	public Movimentacao findById(Integer id) {
		Optional<Movimentacao> movimentacao = movimentacaoRepository.findById(id);
		
		return movimentacao.get();
	}

	public Movimentacao insert(Movimentacao movimentacao) {
		
		movimentacaoRepository.save(movimentacao);
		return movimentacao;
	}

	public void delete(Integer id) {
		try {
			movimentacaoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new DBException(e.getMessage());
		} catch (DataIntegrityViolationException e) {
			throw new DBException(e.getMessage());
		}

	}

	public Movimentacao update(Integer id, Movimentacao movimentacao) {
		try {
			Movimentacao entity = movimentacaoRepository.getOne(id);
			updateData(entity, movimentacao);
			return movimentacaoRepository.save(entity);
		
		}catch(EntityNotFoundException e) {
			throw new DBException(e.getMessage());
		}
		
	}

	private void updateData(Movimentacao entity, Movimentacao movimentacao) {
		entity.setNameNavio(movimentacao.getNameNavio());
		entity.setTipoMovimentacao(movimentacao.getTipoMovimentacao());
		entity.setInicio(movimentacao.getInicio());
		entity.setFim(movimentacao.getFim());
	}
	
	public List<Movimentacao>pesquisa(String nome){
		List<Movimentacao> list = movimentacaoRepository.pesquisa(nome);
		return list;
	}
	
}
