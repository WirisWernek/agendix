package io.github.wiriswernek.agendix.model.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.github.wiriswernek.agendix.model.entity.Base.BaseEntity;
import io.github.wiriswernek.agendix.model.enums.TipoUsuarioEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "USUARIO")
public class UsuarioEntity extends BaseEntity implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "LOGIN")
	@NotNull(message = "Login não pode ser nulo!")
	@NotBlank(message = "Login não pode ser vazio!")
	private String login;

	@Column(name = "PASSWORD")
	@NotNull(message = "A senha não pode ser nulo!")
	@NotBlank(message = "A senha não pode ser vazio!")
	private String password;

	@Column(name = "EMAIL")
	@NotNull(message = "O Email não pode ser nulo!")
	@NotBlank(message = "O Email não pode ser vazio!")
	private String email;
	
	@Column(name = "CPF")
	@NotNull(message = "O CPF não pode ser nulo!")
	@NotBlank(message = "O CPF não pode ser vazio!")
	private String cpf;

	@Column(name = "TELEFONE")
	@NotNull(message = "O Telefone não pode ser nulo!")
	@NotBlank(message = "O Telefone não pode ser vazio!")
	private String telefone;

	@Column(name = "WHATSAPP")
	@NotBlank(message = "O WhatsApp não pode ser vazio!")
	private String whatsapp;
	
	@Column(name = "OBSERVACOES")
	@NotBlank(message = "As Observações não podem ser vazias!")
	private String observacoes;

	@Column(name = "DATA_NASCIMENTO")
	@NotNull(message = "Data de Criação não pode ser nula!")
	private LocalDateTime dataNascimento;

	@Column(name = "ATIVO")
	@NotNull(message = "O Status não pode ser nulo!")
	private Boolean ativo;

	@Column(name = "ROLE")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "A role não pode ser nula!")
	private TipoUsuarioEnum role;

	@Column(name = "NOME")
	@NotNull(message = "O Nome não pode ser nulo!")
	@NotBlank(message = "O Nome não pode ser vazio!")
	private String nome;

	@Column(name = "DATA_CRIACAO")
	@NotNull(message = "Data de Criação não pode ser nula!")
	private LocalDateTime dataCriacao;

	@Column(name = "DATA_EXCLUSAO")
	private LocalDateTime dataExclusao;

	@Column(name = "DATA_ATUALIZACAO")
	private LocalDateTime dataAtualizacao;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (this.role == TipoUsuarioEnum.ADMINISTRADOR) {
			return List.of(
					new SimpleGrantedAuthority("ROLE_" + TipoUsuarioEnum.ADMINISTRADOR.name()),
					new SimpleGrantedAuthority("ROLE_" + TipoUsuarioEnum.CLIENTE.name()),
					new SimpleGrantedAuthority("ROLE_" + TipoUsuarioEnum.PRESTADOR.name()),
					new SimpleGrantedAuthority("ROLE_" + TipoUsuarioEnum.VISITANTE.name())
				);
		} else if (this.role == TipoUsuarioEnum.PRESTADOR) {
			return List.of(
					new SimpleGrantedAuthority("ROLE_" + TipoUsuarioEnum.PRESTADOR.name()),
					new SimpleGrantedAuthority("ROLE_" + TipoUsuarioEnum.CLIENTE.name()),
					new SimpleGrantedAuthority("ROLE_" + TipoUsuarioEnum.VISITANTE.name())
				);
		} else if (this.role == TipoUsuarioEnum.CLIENTE) {
			return List.of(
					new SimpleGrantedAuthority("ROLE_" + TipoUsuarioEnum.CLIENTE.name()),
					new SimpleGrantedAuthority("ROLE_" + TipoUsuarioEnum.VISITANTE.name())
				);
		} else {
			return List.of(new SimpleGrantedAuthority("ROLE_" + TipoUsuarioEnum.VISITANTE.name()));
		}

	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		if (ativo) {
			return true;
		}
		return false;
	}

	public String getCpf() {
		return "";
	}

}
