package com.crudt2s.springboot.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.crudt2s.springboot.entities.Conteiner;
import com.crudt2s.springboot.exceptions.DBException;
import com.crudt2s.springboot.repositories.ConteinerRepository;



@Service
public class ConteinerService {

	@Autowired
	private ConteinerRepository conteinerRepository;
	
	public List<Conteiner> findAll(){
		return conteinerRepository.findAll();
	}
	
	public Conteiner findById(Integer id) {
		Optional<Conteiner>conteiner = conteinerRepository.findById(id);
		return conteiner.get();
	}
	
	public Conteiner insert(Conteiner conteiner) {
		return conteinerRepository.save(conteiner);
	}
	
	public void delete(Integer id) {
		try {
			conteinerRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new DBException(e.getMessage());
		}catch (DataIntegrityViolationException e) {
			throw new DBException(e.getMessage());
		}
		
		
	}
	
	public Conteiner update(Integer id, Conteiner conteiner) {
		try {
			Conteiner entity = conteinerRepository.getOne(id);
			updateData(entity, conteiner);
			return conteinerRepository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new DBException(e.getMessage());
		}
		
	}
	
	private void updateData(Conteiner entity,Conteiner conteiner) {
		entity.setNomeCliente(conteiner.getNomeCliente());
		entity.setNumeroCntr(conteiner.getNumeroCntr());
		entity.setCategoria(conteiner.getCategoria());
		entity.setStatus(conteiner.getStatus());
		entity.setTipo(conteiner.getTipo());
	}
	
}
