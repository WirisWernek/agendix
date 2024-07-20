package io.github.wiriswernek.agendix.base;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;


public abstract class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	protected Long id;

	@Column(name = "DATA_CRIACAO")
	@NotNull(message = "Data de Criação não pode ser nula!")
	protected LocalDateTime dataCriacao;

	@Column(name = "DATA_EXCLUSAO")
	protected LocalDateTime dataExclusao;

	@Column(name = "DATA_ATUALIZACAO")
	protected LocalDateTime dataAtualizacao;
}
