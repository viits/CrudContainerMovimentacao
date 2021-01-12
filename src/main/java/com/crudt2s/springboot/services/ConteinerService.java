package com.crudt2s.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudt2s.springboot.entities.Conteiner;
import com.crudt2s.springboot.repositories.ConteinerRepository;

@Service
public class ConteinerService {

	@Autowired
	private ConteinerRepository conteinerRepository;
	
	public List<Conteiner> findAll(){
		return conteinerRepository.findAll();
	}
	
}
