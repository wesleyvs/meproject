package com.meproject.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.meproject.entity.Pessoa;
import com.meproject.repository.PessoaRepository;


@Service("SecurityService")
public class ServiceImpl implements Services {

    @Autowired
    private PessoaRepository pessoaRepo;
    
    @Override
    public List<Pessoa> buscarTodasPessoas() {
        return pessoaRepo.findAll();
    }
    
    @Override
    public Pessoa buscarPessoaPorId(Long idPessoa) {
        Optional<Pessoa> pessoaOp = pessoaRepo.findById(idPessoa);
        if (pessoaOp.isPresent()) {
            return pessoaOp.get();
        } else {
            throw new RuntimeException("Pessoa não encontrada!");
        }
    }
    
    @Override
    public List<Pessoa> buscarPessoaPorNome(String nomePessoa) {
        List<Pessoa> pessoa = pessoaRepo.findByNomePessoa(nomePessoa);
        Optional<List<Pessoa>> pessoaOp = Optional.of(pessoa);

        if (!pessoaOp.isEmpty()) {
            return pessoaOp.get();
        } else {
            throw new RuntimeException("Pessoa não encontrada!");
        }
    }

    @Transactional
    public Pessoa criarPessoa(String nomePessoa, String dataNascimento, String estadoCivil, Long dependentes) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNomePessoa(nomePessoa);
        pessoa.setDataNascimento(dataNascimento);
        pessoa.setEstadoCivil(estadoCivil);
        pessoa.setDependentes(dependentes);
        pessoaRepo.save(pessoa);
        return pessoa;
    }

    @Transactional
    public String deletarPessoa(Long id) {
        Optional<Pessoa> pessoaOp = pessoaRepo.findById(id);
        if (pessoaOp.isPresent()) {
            pessoaRepo.delete(pessoaOp.get());
            return "Pessoa deletada com sucesso!";
        } else {
            throw new RuntimeException("Pessoa não encontrada!");
        }
    }
    
    @Transactional
    public Pessoa alterarPessoa(Long idPessoa, String nomePessoa, String dataNascimento, String estadoCivil, Long dependentes) {
        Optional<Pessoa> pessoaOp = pessoaRepo.findById(idPessoa);
        System.out.print(pessoaOp);        
        if (pessoaOp.isPresent()) {
            pessoaOp.get().setNomePessoa(nomePessoa);
            pessoaOp.get().setDataNascimento(dataNascimento);
            pessoaOp.get().setEstadoCivil(estadoCivil);
            pessoaOp.get().setDependentes(dependentes);
            return pessoaOp.get();
        } else {
        	return criarPessoa(nomePessoa, dataNascimento, estadoCivil, dependentes);
        }
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
    
}
