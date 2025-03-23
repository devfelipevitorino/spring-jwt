package com.devfelipevitorino.springjwt.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios", uniqueConstraints = { 
	      @UniqueConstraint(columnNames = "username"),
	      @UniqueConstraint(columnNames = "email") 
	    })
public class Usuario {

	@NotBlank
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@NotBlank
	@Size(max = 20)
	private String nome;
	
	@NotBlank
	@Email
	@Size(max = 50)
	private String email;
	
	@NotBlank
	@Size(max = 120)
	private String senha;
	
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(  name = "usuario_funcao", 
	        joinColumns = @JoinColumn(name = "usuario_id"), 
	        inverseJoinColumns = @JoinColumn(name = "funcao_id"))
	  private Set<Funcao> funcoes = new HashSet<>();

	public Usuario() {}
	
	public Usuario(@NotBlank @Size(max = 20) String nome, @NotBlank @Email @Size(max = 50) String email,
			@NotBlank @Size(max = 120) String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Funcao> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(Set<Funcao> funcoes) {
		this.funcoes = funcoes;
	}

}
