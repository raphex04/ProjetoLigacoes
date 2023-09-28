package com.ligacoes1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ligacoes1.entities.Agenda;

public interface AgendaRepository  extends JpaRepository<Agenda, Long>{
	
}