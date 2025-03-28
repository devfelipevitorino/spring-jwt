package com.devfelipevitorino.springjwt.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.devfelipevitorino.springjwt.models.Usuario;

public class UserDetailsImpl implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;

	public UserDetailsImpl(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return usuario.getFuncao()
				.stream()
				.map(funcao -> new SimpleGrantedAuthority(funcao.getNome().name()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return usuario.getSenha();
	}

	@Override
	public String getUsername() {
		return usuario.getNome();
	}	

	@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
