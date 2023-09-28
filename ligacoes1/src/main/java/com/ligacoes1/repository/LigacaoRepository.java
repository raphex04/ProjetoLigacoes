package com.ligacoes1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ligacoes1.entities.Ligacao;

public interface LigacaoRepository  extends JpaRepository<Ligacao, Long>{
	
}