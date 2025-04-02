package com.devfelipevitorino.springjwt.security.service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.devfelipevitorino.springjwt.security.UserDetailsImpl;

@Service
public class JwtTokenService {
	
	private static final String SECRET_KEY = "4Z^XrroxR@dWxqf$mTTKwW$!@#qGr4P";
	
	private static final String ISSUER = "token-api";
	
	public String geradorToken(UserDetailsImpl usuario) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
			return JWT.create()
					.withIssuer(ISSUER)
					.withIssuedAt(dataCriar())
					.withExpiresAt(dataExpirar())
					.withSubject(usuario.getUsername())
					.sign(algorithm);
		} catch (Exception e) {
			throw new JWTCreationException("Erro ao gerar o token", e);
		}
	}
	
    public String getSubjectFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject(); 
        } catch (JWTVerificationException exception){
            throw new JWTVerificationException("Token inválido ou expirado.");
        }
    }

	private Instant dataCriar() {
		return ZonedDateTime.now(ZoneId.of("America/Recife")).toInstant();
	}
	
	private Instant dataExpirar() {
		return ZonedDateTime.now(ZoneId.of("America/Recife")).plusHours(4).toInstant();
	}
}
