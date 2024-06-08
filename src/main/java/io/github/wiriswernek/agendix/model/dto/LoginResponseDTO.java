package io.github.wiriswernek.agendix.model.dto;

import io.github.wiriswernek.agendix.model.enums.TipoUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginResponseDTO {

	private String token;
	private TipoUsuarioEnum role;
}
