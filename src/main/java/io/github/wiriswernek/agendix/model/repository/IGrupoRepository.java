package io.github.wiriswernek.agendix.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.wiriswernek.agendix.model.entity.GrupoEntity;
import io.github.wiriswernek.agendix.model.repository.Base.IBaseRepository;

public interface IGrupoRepository extends JpaRepository<GrupoEntity, Long>, IBaseRepository<GrupoEntity>{
	Optional<GrupoEntity> findByNome(String nome);
}
