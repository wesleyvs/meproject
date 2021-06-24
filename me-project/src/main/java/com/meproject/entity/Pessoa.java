package com.meproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_fisica")
public class Pessoa {
	
    @Id
    @SequenceGenerator(name="meproject_id_seq",
                       sequenceName="meproject_id_seq",
                       allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator="meproject_id_seq")
    @Column(name = "id", updatable=false)
	private Long idPessoa;
	
    @Column(name = "pessoa_nome")	
    private String nomePessoa;
	
    @Column(name = "pessoa_data_nascimento")
	private String dataNascimento;
	
    @Column(name = "pessoa_estado_civil")
	private String estadoCivil;
	
    @Column(name = "pessoa_dependentes")
	private Long dependentes;

	public Long getIdPessoa() {
		return idPessoa;
	}  

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Long getDependentes() {
		return dependentes;
	}

	public void setDependentes(Long dependentes) {
		this.dependentes = dependentes;
	}
	
}