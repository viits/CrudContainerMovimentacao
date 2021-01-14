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

	public List<Movimentacao> findAll() {
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
	
	@Transactional(readOnly = true)
	public List<Movimentacao> geraRelatorioImportacao() {
		List<Movimentacao> list = movimentacaoRepository.relatoriosImportacao();
		return list;
	}
	
	@Transactional(readOnly = true)
	public List<Movimentacao> geraRelatorioExportacao() {
		List<Movimentacao> list = movimentacaoRepository.relatoriosExportacao();
		return list;
	}

}
