package com.devfelipevitorino.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devfelipevitorino.springjwt.models.Funcao;
import com.devfelipevitorino.springjwt.models.enums.EFuncao;

public interface FuncaoRepository extends JpaRepository<Funcao, Long>{
	
	Optional<Funcao> findByNome(EFuncao funcao);
	
}
