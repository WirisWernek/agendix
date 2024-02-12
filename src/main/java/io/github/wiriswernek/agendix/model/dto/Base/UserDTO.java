package io.github.wiriswernek.agendix.model.dto.Base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO extends BaseDTO {

	private String password;
	private String clientId;
	private String grantType;
	private String username;
}
