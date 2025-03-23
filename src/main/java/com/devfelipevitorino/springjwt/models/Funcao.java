package com.devfelipevitorino.springjwt.models;

import com.devfelipevitorino.springjwt.models.enums.EFuncao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcao")
public class Funcao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EFuncao nome;

	public Funcao() {}

	public Funcao(EFuncao nome) {
		this.nome = nome;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EFuncao getNome() {
		return nome;
	}

	public void setNome(EFuncao nome) {
		this.nome = nome;
	}
	
}
