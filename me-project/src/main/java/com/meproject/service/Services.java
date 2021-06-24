package com.meproject.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.meproject.entity.Pessoa;

public interface Services extends UserDetailsService {

	public List<Pessoa> buscarTodasPessoas();
	
	public Pessoa buscarPessoaPorId(Long idPessoa);
	
	public List<Pessoa> buscarPessoaPorNome(String nomePessoa);
	
	public Pessoa criarPessoa(String nomePessoa, String dataNascimento, String estadoCivil, Long dependentes);
	
	public String deletarPessoa(Long idPessoa);
	
	public Pessoa alterarPessoa(Long idPessoa, String nomePessoa, String dataNascimento, String estadoCivil, Long dependentes);

}
