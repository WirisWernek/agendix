package io.github.wiriswernek.agendix.model.entity.Base;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public abstract class BaseEntity {

	@Column(name = "ID_ORGANIZACAO")
	@NotNull(message = "IdOrganização não pode ser nulo!")
	@NotBlank(message = "IdOrganização não pode ser vazio!")
	protected Long idOrganizacao;

	@Column(name = "DATA_CRIACAO")
	@NotNull(message = "Data de Criação não pode ser nula!")
	protected LocalDateTime dataCriacao;

	@Column(name = "DATA_EXCLUSAO")
	protected LocalDateTime dataExclusao;

	@Column(name = "DATA_ATUALIZACAO")
	protected LocalDateTime dataAtualizacao;
}
