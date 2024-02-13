package io.github.wiriswernek.agendix.model.dto;

import java.time.LocalDateTime;

import io.github.wiriswernek.agendix.model.dto.Base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrupoUsuarioDTO extends BaseDTO {
	private Long idOrganizacao;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataExclusao;
	private LocalDateTime dataAtualizacao;
}
