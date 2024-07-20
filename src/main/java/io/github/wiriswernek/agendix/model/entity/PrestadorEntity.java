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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "PRESTADOR")
public class PrestadorEntity extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME")
	@NotNull(message = "Nome não pode ser nulo!")
	@NotBlank(message = "Nome não pode ser vazio!")
	private String nome;

	@Column(name = "RAZAO_SOCIAL")
	@NotNull(message = "Razão Social não pode ser nulo!")
	@NotBlank(message = "Razão Social não pode ser vazio!")
	private String razaoSocial;

	@Column(name = "CNPJ")
	@NotNull(message = "CNPJ não pode ser nulo!")
	@NotBlank(message = "CNPJ não pode ser vazio!")
	private String cnpj;

	@Column(name = "ATIVO")
	@NotNull(message = "O Status não pode ser nulo!")
	private Boolean ativo;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID")
	private UsuarioEntity usuario;

	@OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER)
	private List<AgendamentoEntity> agendamentos;

	@OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER)
	private List<AvaliacaoEntity> avaliacoes;

	@OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER)
	private List<AtendimentoPersonalizadoEntity> personalizacao;

	@OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER)
	private List<ServicoEntity> servicos;

	@OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER)
	private List<LinkEntity> links;

	@OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER)
	private List<ComunicadoEntity> comunicados;

	@OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER)
	private List<HorarioPorDiaEntity> horariosAtendimento;

	@OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER)
	private List<ParametrizacaoHorarioEntity> parametrizacaoHorarios;
}
