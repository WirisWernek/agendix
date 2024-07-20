package io.github.wiriswernek.agendix.model.entity;

import java.time.LocalTime;

import io.github.wiriswernek.agendix.base.BaseEntity;
import io.github.wiriswernek.agendix.model.enums.DiaSemanaEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "HORARIO_POR_DIA")
public class HorarioPorDiaEntity extends BaseEntity {
	@Column(name = "INICIO_ATENDIMENTO")
	@NotNull(message = "Hora do Início do Atendimento não pode ser nula!")
	protected LocalTime inicioAtendimento;

	@Column(name = "FIM_ATENDIMENTO")
	@NotNull(message = "Hora do Fim do Atendimento não pode ser nula!")
	protected LocalTime fimAtendimento;

	@Column(name = "INICIO_INTERVALO")
	@NotNull(message = "Hora do Início do Intervalo não pode ser nula!")
	protected LocalTime inicioIntervalo;

	@Column(name = "FIM_INTERVALO")
	@NotNull(message = "Hora do Fim do Intervalo não pode ser nula!")
	protected LocalTime fimIntervalo;

	@Column(name = "DIA")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O Dia não pode ser nulo!")
	private DiaSemanaEnum tipo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRESTADOR", referencedColumnName = "ID")
	private PrestadorEntity prestador;
}
