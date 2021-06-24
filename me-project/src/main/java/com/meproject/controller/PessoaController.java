package com.meproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.meproject.entity.Pessoa;
import com.meproject.service.Services;

@RestController
@RequestMapping(value = "/pessoa")
@CrossOrigin
public class PessoaController {
	
	@Autowired
    private Services service;
	
    @GetMapping()
    public List<Pessoa> buscarTodasPessoas() {
        return service.buscarTodasPessoas();
    }
    
    @GetMapping(value = "/buscaPorID/{idPessoa}")
    public Pessoa buscarPessoaPorId(@PathVariable("idPessoa") Long idPessoa) {
        return service.buscarPessoaPorId(idPessoa);
    }
    
    @GetMapping(value = "/buscaPorNome/{nomePessoa}")
    public List<Pessoa> buscarPessoaPorNome(@PathVariable("nomePessoa") String nomePessoa) {
        return service.buscarPessoaPorNome(nomePessoa);
    }
    
    @PostMapping(value = "/criarPessoa")
    public ResponseEntity<Pessoa> cadastrarNovoUsuario(@RequestBody Pessoa pessoa, 
        UriComponentsBuilder uriComponentsBuilder) {
        
        pessoa  = service.criarPessoa(pessoa.getNomePessoa(), pessoa.getDataNascimento(), pessoa.getEstadoCivil(), pessoa.getDependentes());        
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(
            uriComponentsBuilder.path(
                "/pessoa/" + pessoa.getIdPessoa()).build().toUri());

        return new ResponseEntity<Pessoa>(pessoa, responseHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/deletarPessoa/{idPessoa}")
    public String deletarUsuario(@PathVariable Long idPessoa) {
        return service.deletarPessoa(idPessoa);
    }
    
    @PutMapping(value = "/alterarPessoa")
    public ResponseEntity<Pessoa> alterarUsuario(@RequestBody Pessoa pessoa, 
        UriComponentsBuilder uriComponentsBuilder) {

        pessoa  = service.alterarPessoa(pessoa.getIdPessoa(), pessoa.getNomePessoa(), pessoa.getDataNascimento(), pessoa.getEstadoCivil(), pessoa.getDependentes());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(
            uriComponentsBuilder.path(
                "/pessoa/" + pessoa.getIdPessoa()).build().toUri());

        return new ResponseEntity<Pessoa>(pessoa, responseHeaders, HttpStatus.CREATED);
    }
}
