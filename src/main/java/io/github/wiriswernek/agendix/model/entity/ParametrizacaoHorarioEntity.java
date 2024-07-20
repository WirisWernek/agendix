package io.github.wiriswernek.agendix.model.entity;

import java.time.LocalTime;

import io.github.wiriswernek.agendix.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "PARAMETRIZACAO_HORARIO")
public class ParametrizacaoHorarioEntity extends BaseEntity {
	@Column(name = "TEMPO_MEDIO")
	@NotNull(message = "O Tempo Médio não pode ser nula!")
	protected LocalTime tempoMedio;

	@Column(name = "ATENDE_DOMINGO")
	@NotNull(message = "A Parametrização de Atendimento do Domingo não pode ser nulo!")
	private Boolean atendeDomingo;

	@Column(name = "ATENDE_SEGUNDA")
	@NotNull(message = "A Parametrização de Atendimento da Segunda-feira não pode ser nulo!")
	private Boolean atendeSegunda;

	@Column(name = "ATENDE_TERCA")
	@NotNull(message = "A Parametrização de Atendimento da Terça-feira não pode ser nulo!")
	private Boolean atendeTerca;

	@Column(name = "ATENDE_QUARTA")
	@NotNull(message = "A Parametrização de Atendimento da Quarta-feira não pode ser nulo!")
	private Boolean atendeQuarta;

	@Column(name = "ATENDE_QUINTA")
	@NotNull(message = "A Parametrização de Atendimento da Quinta-feira não pode ser nulo!")
	private Boolean atendeQuinta;

	@Column(name = "ATENDE_SEXTA")
	@NotNull(message = "A Parametrização de Atendimento da Sexta-feira não pode ser nulo!")
	private Boolean atendeSexta;

	@Column(name = "ATENDE_SABADO")
	@NotNull(message = "A Parametrização de Atendimento do Sábado não pode ser nulo!")
	private Boolean atendeSabado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRESTADOR", referencedColumnName = "ID")
	private PrestadorEntity prestador;
}
