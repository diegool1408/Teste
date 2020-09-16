package br.com.sicredi.assembly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.com.sicredi.assembly.entity.Pauta;
import br.com.sicredi.assembly.repository.PautaRepository;

@RestController
public class PautaController {
	
    @Autowired
    private PautaRepository _pautaRepository;
    
    @RequestMapping(value = "/pauta", method = RequestMethod.GET)
    public List<Pauta> Get() {
        return _pautaRepository.findAll();
    }
    
    
    @RequestMapping(value = "/pauta/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pauta> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Pauta> pauta = _pautaRepository.findById(id);
        if(pauta.isPresent())
            return new ResponseEntity<Pauta>(pauta.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    @RequestMapping(value = "/pauta", method =  RequestMethod.POST)
    public Pauta Post(@Validated @RequestBody Pauta pauta)
    {
        return _pautaRepository.save(pauta);
    }

    @RequestMapping(value = "/pauta/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Pauta> Put(@PathVariable(value = "id") long id, @Validated @RequestBody Pauta newPauta)
    {
        Optional<Pauta> oldPauta = _pautaRepository.findById(id);
        if(oldPauta.isPresent()){
            Pauta pauta = oldPauta.get();
            pauta.setDescricao(newPauta.getDescricao());
            _pautaRepository.save(pauta);
            return new ResponseEntity<Pauta>(pauta, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/pauta/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Pauta> pauta = _pautaRepository.findById(id);
        if(pauta.isPresent()){
        	_pautaRepository.delete(pauta.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
