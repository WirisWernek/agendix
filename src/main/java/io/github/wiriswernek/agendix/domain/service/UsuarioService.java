package io.github.wiriswernek.agendix.domain.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.wiriswernek.agendix.base.BaseService;
import io.github.wiriswernek.agendix.model.dto.UsuarioDTO;
import io.github.wiriswernek.agendix.model.entity.UsuarioEntity;
import io.github.wiriswernek.agendix.model.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService extends BaseService<UsuarioDTO, UsuarioEntity> {
	private final IUsuarioRepository repository;
	private final PasswordEncoder passwordEncoder;

	
	// @Transactional
	// public UsuarioDTO obterUsuarioComPermissoes(String login) {
	// 	var usuarioOptional = repository.findByLogin(login);
	// 	if (usuarioOptional.isEmpty()) {
	// 		return null;
	// 	}
	// 	UsuarioEntity usuario = usuarioOptional.get();
	// 	List<String> permissoes = grupoUsuarioRepository.findPermissoesByUsuario(usuario);
	// 	UsuarioDTO dto = modelMapper.map(usuario, UsuarioDTO.class);
	// 	dto.setPermissoes(permissoes);
	// 	return dto;
	// }
}
