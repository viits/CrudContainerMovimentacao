package com.crudt2s.springboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crudt2s.springboot.entities.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
	
	@Query(value = "SELECT m, c.nomeCliente, COUNT(c.categoria) FROM Movimentacao m INNER JOIN m.conteiner c, Conteiner WHERE c.categoria = 0")
//			 countQuery = "SELECT count(c.categoria)  FROM Container ")
	public List<Movimentacao> relatoriosImportacao();


	@Query(value = "SELECT m, c.nomeCliente, COUNT(c.categoria) FROM Movimentacao m INNER JOIN m.conteiner c, Conteiner WHERE c.categoria = 1")
	public List<Movimentacao> relatoriosExportacao();
	
}
