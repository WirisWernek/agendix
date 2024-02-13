package io.github.wiriswernek.agendix.model.entity;

import java.time.LocalDateTime;

import io.github.wiriswernek.agendix.model.entity.Base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GRUPO_USUARIO")
public class GrupoUsuarioEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private UsuarioEntity usuario;

	@ManyToOne
	@JoinColumn(name = "ID_GRUPO")
	private GrupoEntity grupo;

	@Column(name = "ID_ORGANIZACAO")
	@NotNull(message = "IdOrganização não pode ser nulo!")
	private Long idOrganizacao;

	@Column(name = "DATA_CRIACAO")
	@NotNull(message = "Data de Criação não pode ser nula!")
	private LocalDateTime dataCriacao;

	@Column(name = "DATA_EXCLUSAO")
	private LocalDateTime dataExclusao;

	@Column(name = "DATA_ATUALIZACAO")
	private LocalDateTime dataAtualizacao;

	public GrupoUsuarioEntity(UsuarioEntity usuario, GrupoEntity grupo){
		this.usuario = usuario;
		this.grupo = grupo;
		this.dataCriacao = LocalDateTime.now();
		this.idOrganizacao = 1L;
	}
}
