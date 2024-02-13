package io.github.wiriswernek.agendix.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import io.github.wiriswernek.agendix.model.dto.Base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO extends BaseDTO {

	private Long id;
	private String login;
	private String password;
	private String email;
	private Boolean ativo;
	private String nome;
	private Long idOrganizacao;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataExclusao;
	private LocalDateTime dataAtualizacao;
	private List<String> permissoes;
}
