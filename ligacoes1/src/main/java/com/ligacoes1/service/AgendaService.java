package com.ligacoes1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligacoes1.entities.Agenda;
import com.ligacoes1.repository.AgendaRepository;

@Service
public class AgendaService {
	private final AgendaRepository agendaRepository;

	@Autowired
	public AgendaService(AgendaRepository agendaRepository) {
		this.agendaRepository = agendaRepository;
	}

	public List<Agenda> buscaTodosAgenda(){
		return agendaRepository.findAll();
	}

	public Agenda buscaAgendaId(Long id) {
		Optional <Agenda> agenda = agendaRepository.findById(id);
		return agenda.orElse(null);
	}

	public Agenda SalvaAgenda(Agenda agenda) {
		return agendaRepository.save(agenda);
	}
	public Agenda alterarAgenda(Long id, Agenda alterarFunc) {
		Optional <Agenda> existeAgenda = agendaRepository.findById(id);

		if (existeAgenda.isPresent()) {
			alterarFunc.setId(id);
			return agendaRepository.save(alterarFunc);
		}
		return null;
	}
	public boolean apagarAgenda(Long id) {
		Optional <Agenda> existeAgenda = agendaRepository.findById(id);
		if (existeAgenda.isPresent()) {
			agendaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}