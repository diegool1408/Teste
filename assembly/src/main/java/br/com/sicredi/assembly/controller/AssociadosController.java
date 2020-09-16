package br.com.sicredi.assembly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.assembly.entity.Associados;
import br.com.sicredi.assembly.repository.AssociadosRepository;


@RestController
public class AssociadosController {
	
    @Autowired
    private AssociadosRepository _associadosRepository;
    
    @RequestMapping(value = "/associados", method = RequestMethod.GET)
    public List<Associados> Get() {
        return _associadosRepository.findAll();
    }
    
    
    @RequestMapping(value = "/associados/{id}", method = RequestMethod.GET)
    public ResponseEntity<Associados> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Associados> associados = _associadosRepository.findById(id);
        if(associados.isPresent())
            return new ResponseEntity<Associados>(associados.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    @RequestMapping(value = "/associados", method =  RequestMethod.POST)
    public Associados Post(@Validated @RequestBody Associados associados)
    {
        return _associadosRepository.save(associados);
    }

    @RequestMapping(value = "/associados/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Associados> Put(@PathVariable(value = "id") long id, @Validated @RequestBody Associados newAssociado)
    {
        Optional<Associados> oldAssociado = _associadosRepository.findById(id);
        if(oldAssociado.isPresent()){
            Associados associado = oldAssociado.get();
            associado.setAgencia(newAssociado.getAgencia());
            associado.setConta(newAssociado.getConta());
            associado.setCpf(newAssociado.getCpf());
            associado.setEndereco(newAssociado.getEndereco());
            associado.setNome(newAssociado.getNome());
            _associadosRepository.save(associado);
            return new ResponseEntity<Associados>(associado, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/associados/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Associados> associado = _associadosRepository.findById(id);
        if(associado.isPresent()){
        	_associadosRepository.delete(associado.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
