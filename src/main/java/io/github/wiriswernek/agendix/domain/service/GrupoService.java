package io.github.wiriswernek.agendix.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.wiriswernek.agendix.domain.service.Base.BaseService;
import io.github.wiriswernek.agendix.model.dto.GrupoDTO;
import io.github.wiriswernek.agendix.model.entity.GrupoEntity;
import io.github.wiriswernek.agendix.model.repository.IGrupoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrupoService extends BaseService<GrupoDTO, GrupoEntity> {
	private final IGrupoRepository repository;

	@Transactional
	public GrupoDTO insert(GrupoDTO dto) {
		GrupoEntity entity = modelMapper.map(dto, GrupoEntity.class);
		return modelMapper.map(repository.save(entity), GrupoDTO.class);
	}

	@Transactional
	public List<GrupoDTO> getAll() {
		return modelMapper.map(repository.findAll(), listTypeDTO);
	}
}
