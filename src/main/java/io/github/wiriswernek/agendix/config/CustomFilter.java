package io.github.wiriswernek.agendix.config;

import java.io.IOException;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.github.wiriswernek.agendix.domain.security.CustomAuthentication;
import io.github.wiriswernek.agendix.domain.security.IdentificacaoUsuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomFilter extends OncePerRequestFilter {
	// Possivelmente irrelevante para o contexto da aplicação
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String secretHeader = request.getHeader("x-secret");

		if (secretHeader != null) {
			if (secretHeader.equals("secr3t")) {
				IdentificacaoUsuario identificacao = new IdentificacaoUsuario("Usuário Secreto", "x-secret",
						List.of("SECRET", "USER"));

				Authentication authentication = new CustomAuthentication(identificacao);
				SecurityContext securityContext = SecurityContextHolder.getContext();
				securityContext.setAuthentication(authentication);

			}
		}
		filterChain.doFilter(request, response);
	}

}
