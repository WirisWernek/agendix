package io.github.wiriswernek.agendix.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import io.github.wiriswernek.agendix.base.IBaseRepository;
import io.github.wiriswernek.agendix.model.entity.UsuarioEntity;


public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long>, IBaseRepository<UsuarioEntity>{
	public UserDetails findByLogin(String login);
}
