package io.github.wiriswernek.agendix.model.entity;

import io.github.wiriswernek.agendix.base.BaseEntity;
import io.github.wiriswernek.agendix.model.enums.TipoLinkEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "LINK")
public class LinkEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "TIPO")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O Tipo do Link não pode ser nulo!")
	private TipoLinkEnum tipo;

	@Column(name = "NOME")
	@NotNull(message = "O Nome não pode ser nulo!")
	@NotBlank(message = "O Nome não pode ser vazio!")
	private String nome;

	@Column(name = "URL")
	@NotNull(message = "A Url não pode ser nula!")
	@NotBlank(message = "A Url não pode ser vazia!")
	private String url;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRESTADOR", referencedColumnName = "ID")
	private PrestadorEntity prestador;
}
