package com.crudt2s.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crudt2s.springboot.entities.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
	
	@Query(value = "SELECT nameNavio FROM Movimentacao  WHERE nameNavio LIKE %:nome%" )
	public List<Movimentacao> pesquisa(@Param("nome")String nome);

	
}
