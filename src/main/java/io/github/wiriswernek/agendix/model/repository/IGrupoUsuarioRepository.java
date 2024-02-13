package io.github.wiriswernek.agendix.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.github.wiriswernek.agendix.model.entity.GrupoUsuarioEntity;
import io.github.wiriswernek.agendix.model.entity.UsuarioEntity;
import io.github.wiriswernek.agendix.model.repository.Base.IBaseRepository;


public interface IGrupoUsuarioRepository extends JpaRepository<GrupoUsuarioEntity, Long>, IBaseRepository<GrupoUsuarioEntity>{

	@Query("select distinct g.nome from GrupoUsuarioEntity ug join ug.grupo g join ug.usuario u where u = ?1 ")
	public List<String> findPermissoesByUsuario(UsuarioEntity usuario);
}
