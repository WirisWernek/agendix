package io.github.wiriswernek.agendix.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wiriswernek.agendix.domain.security.TokenService;
import io.github.wiriswernek.agendix.domain.service.UsuarioService;
import io.github.wiriswernek.agendix.model.dto.LoginDTO;
import io.github.wiriswernek.agendix.model.dto.LoginResponseDTO;
import io.github.wiriswernek.agendix.model.entity.UsuarioEntity;
import lombok.RequiredArgsConstructor;
@RestController
@RequestMapping("authentication")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
	private final AuthenticationManager authenticationManager;
	private final TokenService tokenService;
	private final AuthenticationServiceException authenticationService;
	private final UsuarioService usuarioService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Validated LoginDTO dto) throws Exception {
		try {
			var auth = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha()));
			var user = usuarioService.obterUsuarioComPermissoes(dto.getLogin());
			var usuario = (UsuarioEntity) auth.getPrincipal();
			var token = tokenService.generateToken(usuario, user.getPermissoes().get(0));
			return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDTO(token, user.getPermissoes().get(0)));
		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadCredentialsException("Usuário ou senha invalidos!"));
		} catch (InternalAuthenticationServiceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new InternalAuthenticationServiceException("Usuário ou senha invalidos!"));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
		}
	}
}
