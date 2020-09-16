package br.com.sicredi.assembly.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sicredi.assembly.entity.Sessao;
import br.com.sicredi.assembly.repository.SessaoRepository;

@Service
public class SessaoService implements ISessaoService {
	
    @Autowired
    private SessaoRepository sessaoRepository;

    @Override
    public Optional<Sessao> findById(int id) {

        return sessaoRepository.findById(id);
    }

}
