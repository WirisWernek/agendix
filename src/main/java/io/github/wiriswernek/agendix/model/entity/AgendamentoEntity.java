package io.github.wiriswernek.agendix.model.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import io.github.wiriswernek.agendix.base.BaseEntity;
import io.github.wiriswernek.agendix.model.enums.StatusAgendamentoEnum;
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
import jakarta.persistence.OneToMany;
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
@Table(name = "AGENDAMENTO")
public class AgendamentoEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DATA")
	@NotNull(message = "A Data de Criação não pode ser nula!")
	private LocalDateTime data;

	@Column(name = "INICIO")
	@NotNull(message = "A Hora do Início do Agendamento não pode ser nula!")
	private LocalTime inicio;

	@Column(name = "FIM")
	@NotNull(message = "A Hora do Fim do Agendamento não pode ser nula!")
	private LocalTime fim;

	@Column(name = "STATUS")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O Status não pode ser nulo!")
	private StatusAgendamentoEnum status;

	@Column(name = "JUSTIFICATIVA_CANCELAMENTO_DESISTENCIA")
	@NotBlank(message = "A Justificativa não pode ser vazia!")
	private String justificativa;

	@OneToMany(mappedBy = "agendamento", fetch = FetchType.EAGER)
	private List<ServicoAgendamentoEntity> agendamentos;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
	private UsuarioEntity cliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRESTADOR", referencedColumnName = "ID")
	private PrestadorEntity prestador;
}
