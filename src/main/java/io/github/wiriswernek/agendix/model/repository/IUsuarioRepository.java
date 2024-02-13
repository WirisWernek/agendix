package io.github.wiriswernek.agendix.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.wiriswernek.agendix.model.entity.UsuarioEntity;
import io.github.wiriswernek.agendix.model.repository.Base.IBaseRepository;


public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long>, IBaseRepository<UsuarioEntity>{
	Optional<UsuarioEntity> findByLogin(String login);
}
