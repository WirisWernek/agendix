package io.github.wiriswernek.agendix.model.entity;

import java.util.List;

import io.github.wiriswernek.agendix.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "SERVICO")
public class ServicoEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME")
	@NotNull(message = "O Nome não pode ser nulo!")
	@NotBlank(message = "O Nome não pode ser vazio!")
	private String nome;

	@Column(name = "DESCRICAO")
	@NotNull(message = "A Descrição não pode ser nulo!")
	@NotBlank(message = "A Descrição não pode ser vazio!")
	private String descricao;

	@Column(name = "TEMPO_MEDIO")
	@NotNull(message = "O Tempo Médio não pode ser nulo!")
	private Float tempoMedio;

	@Column(name = "ativo")
	@NotNull(message = "O Status não pode ser nulo!")
	private Boolean ativo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRESTADOR", referencedColumnName = "ID")
	private PrestadorEntity prestador;

	@OneToMany(mappedBy = "servico", fetch = FetchType.EAGER)
	private List<ServicoAgendamentoEntity> agendamentos;

	@OneToMany(mappedBy = "servico", fetch = FetchType.EAGER)
	private List<AtendimentoPersonalizadoEntity> personalizacao;

	@OneToMany(mappedBy = "servico", fetch = FetchType.EAGER)
	private List<ImagemServicoEnitity> imagens;
}
