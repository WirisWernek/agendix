package io.github.wiriswernek.agendix.model.entity;

import java.time.LocalDateTime;

import io.github.wiriswernek.agendix.model.entity.Base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USUARIOS")
public class UsuarioEntity extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name="LOGIN")
	@NotNull(message = "Login não pode ser nulo!")
	@NotBlank(message = "Login não pode ser vazio!")
	private String login;

	@Column(name="PASSWORD")
	@NotNull(message = "A senha não pode ser nulo!")
	@NotBlank(message = "A senha não pode ser vazio!")
	private String password;

	@Column(name="EMAIL")
	@NotNull(message = "O Email não pode ser nulo!")
	@NotBlank(message = "O Email não pode ser vazio!")
	private String email;

	@Column(name="ATIVO")
	@NotNull(message = "O Status não pode ser nulo!")
	private Boolean ativo;

	@Column(name="NOME")
	@NotNull(message = "O Nome não pode ser nulo!")
	@NotBlank(message = "O Nome não pode ser vazio!")
	private String nome;

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

}
