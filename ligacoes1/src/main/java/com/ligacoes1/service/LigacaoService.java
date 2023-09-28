package com.ligacoes1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligacoes1.entities.Ligacao;
import com.ligacoes1.repository.LigacaoRepository;

@Service
public class LigacaoService {
	private final LigacaoRepository ligacaoRepository;

	@Autowired
	public LigacaoService(LigacaoRepository ligacaoRepository) {
		this.ligacaoRepository = ligacaoRepository;
	}

	public List<Ligacao> buscaTodosLigacao(){
		return ligacaoRepository.findAll();
	}

	public Ligacao buscaLigacaoId(Long id) {
		Optional <Ligacao> ligacao = ligacaoRepository.findById(id);
		return ligacao.orElse(null);
	}

	public Ligacao SalvaLigacao(Ligacao ligacao) {
		return ligacaoRepository.save(ligacao);
	}
	public Ligacao alterarLigacao(Long id, Ligacao alterarFunc) {
		Optional <Ligacao> existeLigacao = ligacaoRepository.findById(id);

		if (existeLigacao.isPresent()) {
			alterarFunc.setId(id);
			return ligacaoRepository.save(alterarFunc);
		}
		return null;
	}
	public boolean apagarLigacao(Long id) {
		Optional <Ligacao> existeLigacao = ligacaoRepository.findById(id);
		if (existeLigacao.isPresent()) {
			ligacaoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}