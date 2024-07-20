package io.github.wiriswernek.agendix.model.entity;

import io.github.wiriswernek.agendix.base.BaseEntity;
import io.github.wiriswernek.agendix.model.enums.TipoComunicadoEnum;
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
@Table(name = "Comunicado")
public class ComunicadoEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "TIPO")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O Tipo do Comunicado não pode ser nulo!")
	private TipoComunicadoEnum tipo;

	@Column(name = "CONTEUDO")
	@NotNull(message = "O Conteúdo não pode ser nulo!")
	@NotBlank(message = "O Conteúdo não pode ser vazio!")
	private String conteudo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRESTADOR", referencedColumnName = "ID")
	private PrestadorEntity prestador;

}
