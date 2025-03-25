package com.devfelipevitorino.springjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devfelipevitorino.springjwt.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByUsername();
	
	Boolean ExistePorUsername(String username);
	
	Boolean ExistePorEmail(String email);

}
