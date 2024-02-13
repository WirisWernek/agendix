package io.github.wiriswernek.agendix.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.wiriswernek.agendix.domain.service.Base.BaseService;
import io.github.wiriswernek.agendix.model.dto.UsuarioDTO;
import io.github.wiriswernek.agendix.model.entity.GrupoUsuarioEntity;
import io.github.wiriswernek.agendix.model.entity.UsuarioEntity;
import io.github.wiriswernek.agendix.model.repository.IGrupoRepository;
import io.github.wiriswernek.agendix.model.repository.IGrupoUsuarioRepository;
import io.github.wiriswernek.agendix.model.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService extends BaseService<UsuarioDTO, UsuarioEntity> {
	private final IUsuarioRepository repository;
	private final IGrupoRepository grupoRepository;
	private final IGrupoUsuarioRepository grupoUsuarioRepository;
	private final PasswordEncoder passwordEncoder;

	@Transactional
	public UsuarioDTO insert(UsuarioDTO dto) {
		dto.setAtivo(true);
		dto.setDataCriacao(LocalDateTime.now());
		dto.setIdOrganizacao(1L);
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));

		final UsuarioEntity entity = repository.save(modelMapper.map(dto, UsuarioEntity.class));

		List<GrupoUsuarioEntity> permissoesEncontradas = dto.getPermissoes().stream().map(permissao -> {
			var grupo = grupoRepository.findByNome(permissao);
			if (grupo.isPresent()) {
				return new GrupoUsuarioEntity(entity, grupo.get());
			}
			return null;
		}).filter(grupo -> grupo != null).collect(Collectors.toList());

		var permissoes = grupoUsuarioRepository.saveAll(permissoesEncontradas);

		return modelMapper.map(entity, UsuarioDTO.class);
	}

	@Transactional
	public List<UsuarioDTO> getAll() {
		return modelMapper.map(repository.findAll(), listTypeDTO);
	}

	@Transactional
	public UsuarioDTO obterUsuarioComPermissoes(String login) {
		var usuarioOptional = repository.findByLogin(login);
		if (usuarioOptional.isEmpty()) {
			return null;
		}
		UsuarioEntity usuario = usuarioOptional.get();
		List<String> permissoes = grupoUsuarioRepository.findPermissoesByUsuario(usuario);
		UsuarioDTO dto = modelMapper.map(usuario, UsuarioDTO.class);
		dto.setPermissoes(permissoes);
		return dto;
	}
}
