package io.github.wiriswernek.agendix.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import io.github.wiriswernek.agendix.model.entity.UsuarioEntity;
import io.github.wiriswernek.agendix.model.repository.Base.IBaseRepository;


public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long>, IBaseRepository<UsuarioEntity>{
	public UserDetails findByLogin(String login);
}
