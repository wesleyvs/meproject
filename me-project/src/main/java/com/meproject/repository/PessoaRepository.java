package com.meproject.repository;

import java.util.List;
import java.util.Optional;

import com.meproject.entity.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
		
	public List<Pessoa> findByNomePessoa(String nomePessoa);
	public Optional<Pessoa> findById(Long idPessoa);
}
