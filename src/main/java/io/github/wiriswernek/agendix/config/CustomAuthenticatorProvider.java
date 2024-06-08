package io.github.wiriswernek.agendix.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import io.github.wiriswernek.agendix.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomAuthenticatorProvider implements AuthenticationProvider {

	private final UsuarioService service;
	private final PasswordEncoder encoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String login = authentication.getName();
		String senha = (String) authentication.getCredentials();

		// UsuarioDTO usuario = service.obterUsuarioComPermissoes(login);
		// if (usuario != null) {
		// 	boolean valido = encoder.matches(senha, usuario.getPassword());
		// 	if (valido) {
		// 		IdentificacaoUsuario identificacao = new IdentificacaoUsuario(usuario.getNome(), usuario.getLogin(),
		// 				usuario.getPermissoes());
		// 		return new CustomAuthentication(identificacao);
		// 	}
		// }

		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
