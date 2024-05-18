package io.github.wiriswernek.agendix.domain.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import io.github.wiriswernek.agendix.model.entity.UsuarioEntity;

@Service
public class TokenService {
	@Value("SenhaToken-AlterarDepois")
	private String secret;

	public String generateToken(UsuarioEntity usuario, String role) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create().
					withIssuer("checkpoint")
					.withSubject(usuario.getLogin())
					.withClaim("name", usuario.getNome())
					.withClaim("id", usuario.getId())
					.withClaim("role", role)
					.withExpiresAt(getExpirationDate()).sign(algorithm);

			return token;

		} catch (JWTCreationException e) {
			throw new RuntimeException("Erro ao gerar token! " + e.getMessage());
		}
	}

	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm).withIssuer("checkpoint").build().verify(token).getSubject();

		} catch (JWTVerificationException e) {
			throw new RuntimeException("Usuário não autorizado" + e.getMessage());
		}
	}

	private Instant getExpirationDate() {
		return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
	}
}
