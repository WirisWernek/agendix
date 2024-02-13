package io.github.wiriswernek.agendix.config;

import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import io.github.wiriswernek.agendix.domain.security.CustomAuthentication;
import io.github.wiriswernek.agendix.domain.security.IdentificacaoUsuario;

@Component
public class MasterAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		var login = authentication.getName();
		var senha = (String) authentication.getCredentials();

		var loginMaster = "master";
		var senhaMaster = "@123";
		if (loginMaster.equals(login) && senhaMaster.equals(senha)) {
			IdentificacaoUsuario identificacao = new IdentificacaoUsuario("Master User", loginMaster,
					List.of("MASTER", "ADMIN"));
			return new CustomAuthentication(identificacao);

		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
